package recruit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import recruit.global.model.ApiRes;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BudgetDeleteServiceTest {

    @Autowired
    BudgetDeleteService budgetDeleteService;

    @Test
    void budget_deletion_test() {

        ApiRes<Void> res = budgetDeleteService.delete(1);
        assertTrue(res.getResult().isSuccess());
    }
}