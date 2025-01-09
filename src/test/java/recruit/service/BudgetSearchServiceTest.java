package recruit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import recruit.dto.BudgetListReq;
import recruit.dto.BudgetRes;
import recruit.global.model.ApiRes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BudgetSearchServiceTest {

    @Autowired
    BudgetSearchService budgetSearchService;

    @Test
    void budget_search_test() {
        BudgetListReq req = new BudgetListReq();
        req.setDepartmentSeq(1);
        req.setYear(2025);
        req.setQuarter(1);

        ApiRes<List<BudgetRes>> res = budgetSearchService.list(req);
        System.out.println("res = " + res);
        assertTrue(res.getResult().isSuccess());
        assertEquals(1, res.getData().size());
    }
}