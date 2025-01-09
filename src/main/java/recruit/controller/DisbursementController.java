package recruit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import recruit.dto.DisbursementCreateReq;
import recruit.enumeration.DisbursementStatusEnum;
import recruit.global.model.ApiRes;
import recruit.service.DisbursementSaveService;

import static recruit.enumeration.DisbursementStatusEnum.TEMP;
import static recruit.enumeration.DisbursementStatusEnum.WAITING;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/disbursement")
public class DisbursementController {

    private final DisbursementSaveService disbursementSaveService;

    @PostMapping("/create")
    public ApiRes<Void> create(@RequestBody DisbursementCreateReq req) {
        return disbursementSaveService.save(req, WAITING);
    }

    @PostMapping("/tempsave")
    public ApiRes<Void> tempSave(@RequestBody DisbursementCreateReq req) {
        return disbursementSaveService.save(req, TEMP);
    }

//    @GetMapping("/list")
//    public ApiRes<List<BudgetRes>>list(BudgetListReq req) {
//        return budgetSearchService.list(req);
//    }
//
//    @DeleteMapping("/delete/{seq}")
//    public ApiRes<Void> delete(@PathVariable("seq") long seq) {
//        return budgetDeleteService.delete(seq);
//    }
}
