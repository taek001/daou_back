package recruit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import recruit.dto.BudgetListReq;
import recruit.dto.BudgetReq;
import recruit.dto.BudgetRes;
import recruit.global.model.ApiRes;
import recruit.service.BudgetDeleteService;
import recruit.service.BudgetSaveService;
import recruit.service.BudgetSearchService;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetSaveService budgetSaveService;
    private final BudgetSearchService budgetSearchService;
    private final BudgetDeleteService budgetDeleteService;

    @PostMapping("/create")
    public ApiRes<Void> create(@RequestBody BudgetReq req) {
        return budgetSaveService.save(req);
    }

    @GetMapping("/list")
    public ApiRes<List<BudgetRes>>list(BudgetListReq req) {
        return budgetSearchService.list(req);
    }

    @DeleteMapping("/delete/{seq}")
    public ApiRes<Void> delete(@PathVariable("seq") long seq) {
        return budgetDeleteService.delete(seq);
    }
}
