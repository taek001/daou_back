package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@ToString
public class BudgetListReq {
    private long departmentSeq;
    private int year;
    private int quarter;

    public boolean empty() {
        return departmentSeq <= 0 && year <= 0 && quarter <= 0;
    }
}
