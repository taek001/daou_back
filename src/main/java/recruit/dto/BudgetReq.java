package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BudgetReq {
    private long departmentSeq;
    private int year;
    private int quarter;
    private long amt;
}
