package recruit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recruit.dto.DepartmentRes;
import recruit.entity.Department;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;
import recruit.repository.DepartmentRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentSearchService {

    private final DepartmentRepo departmentRepo;

    public ApiRes<List<DepartmentRes>> list() {
        List<Department> results = departmentRepo.findAll();

        return ApiRes.<List<DepartmentRes>>builder()
                .result(ApiResStatus.builder().success(true).build())
                .data(results.stream().map(DepartmentRes::new).collect(Collectors.toList()))
                .build();
    }
}
