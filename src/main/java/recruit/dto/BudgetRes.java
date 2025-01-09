package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import recruit.entity.Budget;

@Getter
@Setter
@ToString
public class BudgetRes {
    private long seq;
    private String deptN;
    private int year;
    private int quarter;
    private long amt;
    private long spentAmt;
    private long remainingAmt;

    public BudgetRes(Budget entity) {
        this.seq = entity.getSeq();
        this.deptN = entity.getDepartment().getName();
        this.year = entity.getYear();
        this.quarter = entity.getQuarter();
        this.amt = entity.getAmt();
        this.spentAmt = 0;
        this.remainingAmt = 0;
    }
}
