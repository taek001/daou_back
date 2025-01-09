package recruit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import recruit.dto.DepartmentRes;
import recruit.global.model.ApiRes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DepartmentSearchServiceTest {

    @Autowired
    DepartmentSearchService departmentSearchService;

    @Test
    void department_search_test() {
        ApiRes<List<DepartmentRes>> res = departmentSearchService.list();
        assertTrue(res.getResult().isSuccess());
        assertEquals(res.getData().get(0).getName(), "인사팀");
    }

}