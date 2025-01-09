package recruit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import recruit.dto.DisbursementCreateReq;
import recruit.dto.DisbursementItemReq;
import recruit.global.model.ApiRes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static recruit.enumeration.CurrencyTypeEnum.JPY;
import static recruit.enumeration.DisbursementStatusEnum.WAITING;

@SpringBootTest
class DisbursementSaveServiceTest {

    @Autowired
    DisbursementSaveService disbursementSaveService;

    @Test
    void disbursement_save_test() {
        DisbursementItemReq item1 = new DisbursementItemReq();
        item1.setName("교통비");
        item1.setCurrencyType(JPY);
        item1.setQuantity(1);
        item1.setUnitPrice(1000d);
        item1.setExchangeRate(950d);

        DisbursementItemReq item2 = new DisbursementItemReq();
        item2.setName("숙박비");
        item2.setCurrencyType(JPY);
        item2.setQuantity(2);
        item2.setUnitPrice(11342d);
        item2.setExchangeRate(950d);

        List<DisbursementItemReq> items = List.of(item1, item2);

        DisbursementCreateReq req = new DisbursementCreateReq();
        req.setTitle("출장 지출 내역");
        req.setBudgetSeq(1);
        req.setStatus(WAITING);
        req.setItems(items);

        ApiRes<Void> res = disbursementSaveService.save(req);

        assertTrue(res.getResult().isSuccess());
    }
}