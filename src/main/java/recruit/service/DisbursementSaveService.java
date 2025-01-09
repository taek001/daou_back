package recruit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recruit.dto.DisbursementCreateReq;
import recruit.entity.Budget;
import recruit.entity.Disbursement;
import recruit.entity.DisbursementItem;
import recruit.enumeration.DisbursementStatusEnum;
import recruit.global.exception.BasicException;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;
import recruit.repository.DisbursementRepo;

import java.util.stream.Collectors;

import static recruit.enumeration.DisbursementResCode.DISBURSEMENT_SAVE_FAILED;
import static recruit.enumeration.DisbursementStatusEnum.WAITING;

@Service
@RequiredArgsConstructor
public class DisbursementSaveService {

    private final DisbursementRepo disbursementRepo;

    public ApiRes<Void> save(DisbursementCreateReq req, DisbursementStatusEnum status) {
        Disbursement neoDisbursement = Disbursement.builder()
                .title(req.getTitle())
                .status(status)
                .budget(Budget.builder().seq(req.getBudgetSeq()).build())
                .build();

        req.getItems().forEach(item -> neoDisbursement.addItem(new DisbursementItem(item)));

        try {
            disbursementRepo.save(neoDisbursement);
            return ApiRes.<Void>builder().result(ApiResStatus.builder().success(true).build()).build();
        } catch (Exception ex) {
            throw new BasicException(DISBURSEMENT_SAVE_FAILED);
        }


    }
}
