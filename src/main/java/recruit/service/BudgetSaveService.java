package recruit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import recruit.dto.BudgetReq;
import recruit.entity.Budget;
import recruit.entity.Department;
import recruit.global.exception.BasicException;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;
import recruit.repository.BudgetRepo;
import recruit.repository.DepartmentRepo;

import static recruit.enumeration.BudgetResCode.*;

@Service
@RequiredArgsConstructor
public class BudgetSaveService {

    private final BudgetRepo budgetRepo;
    private final DepartmentRepo departmentRepo;

    public ApiRes<Void> save(BudgetReq req) {

        if (departmentRepo.findById(req.getDepartmentSeq()).isEmpty()) {
            throw new BasicException(DEPARTMENT_NOT_FOUND);
        }

        if (!budgetRepo.findByDepartmentAndYearAndQuarter(Department.builder().seq(req.getDepartmentSeq()).build(), req.getYear(), req.getQuarter()).isEmpty()) {
            throw new BasicException(BUDGET_EXIST);
        }

        Budget neoBudget = Budget.builder()
                .department(Department.builder().seq(req.getDepartmentSeq()).build())
                .year(req.getYear())
                .quarter(req.getQuarter())
                .amt(req.getAmt())
                .build();

        try {
            budgetRepo.save(neoBudget);
            return ApiRes.<Void>builder().result(ApiResStatus.builder().success(true).build()).build();
        } catch (IllegalArgumentException | OptimisticLockingFailureException ex) {
            throw new BasicException(BUDGET_SAVE_FAILED);
        }
    }
}
