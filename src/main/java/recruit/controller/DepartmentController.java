package recruit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recruit.dto.DepartmentRes;
import recruit.global.model.ApiRes;
import recruit.service.DepartmentSearchService;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentSearchService departmentSearchService;

    @GetMapping("/list")
    public ApiRes<List<DepartmentRes>>list() {
        return departmentSearchService.list();
    }
}
