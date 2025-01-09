package recruit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recruit.dto.BudgetListReq;
import recruit.dto.BudgetRes;
import recruit.entity.Budget;
import recruit.entity.Department;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;
import recruit.repository.BudgetRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BudgetSearchService {

    private final BudgetRepo budgetRepo;

    public ApiRes<List<BudgetRes>> list(BudgetListReq req) {
        List<Budget> results = (req.empty()) ? budgetRepo.findAll() :
                budgetRepo.findByDepartmentAndYearAndQuarter(
                        Department.builder().seq(req.getDepartmentSeq()).build(),
                        req.getYear(), req.getQuarter()
                );

        return ApiRes.<List<BudgetRes>>builder()
                .result(ApiResStatus.builder().success(true).build())
                .data(results.stream().map(BudgetRes::new).collect(Collectors.toList()))
                .build();
    }
}
