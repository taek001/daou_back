package recruit.service;

import recruit.global.exception.BasicException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import recruit.entity.Budget;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;
import recruit.repository.BudgetRepo;

import static recruit.enumeration.BudgetResCode.*;

@Service
@RequiredArgsConstructor
public class BudgetDeleteService {

    private final BudgetRepo budgetRepo;

    // TODO - 지출결의서 내역이 있으면 삭제할 수 없어야 함!
    public ApiRes<Void> delete(long seq) {

        budgetRepo.findById(seq).orElseThrow(() -> new BasicException(BUDGET_NOT_FOUND_FOR_DELETION));

        try {
            budgetRepo.delete(Budget.builder().seq(seq).build());
            return ApiRes.<Void>builder().result(ApiResStatus.builder().success(true).build()).build();
        } catch (IllegalArgumentException | OptimisticLockingFailureException ex) {
            throw new BasicException(BUDGET_DELETION_FAILED);
        }
    }
}
