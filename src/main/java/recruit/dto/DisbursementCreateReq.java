package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import recruit.entity.Budget;
import recruit.entity.DisbursementItem;
import recruit.enumeration.DisbursementStatusEnum;

import java.util.List;

@Getter
@Setter
@ToString
public class DisbursementCreateReq {
    private String title;
    private long budgetSeq;
    private List<DisbursementItemReq> items;
}
