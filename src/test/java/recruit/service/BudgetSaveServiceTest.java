package recruit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import recruit.dto.BudgetReq;

@SpringBootTest
class BudgetSaveServiceTest {

    @Autowired
    BudgetSaveService budgetSaveService;

    @Test
    void budget_save_test() {
        BudgetReq req = new BudgetReq();
        req.setDepartmentSeq(1);
        req.setYear(2025);
        req.setQuarter(2);
        req.setAmt(1000000);
        budgetSaveService.save(req);
    }
}