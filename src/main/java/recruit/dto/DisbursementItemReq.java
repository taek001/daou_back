package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import recruit.enumeration.CurrencyTypeEnum;
import recruit.enumeration.DisbursementStatusEnum;

@Getter
@Setter
@ToString
public class DisbursementItemReq {
    private String name;
    private CurrencyTypeEnum currencyType;
    private Double exchangeRate;
    private int quantity;
    private Double unitPrice;
}
