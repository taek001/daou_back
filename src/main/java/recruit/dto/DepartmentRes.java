package recruit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import recruit.entity.Department;

@Getter
@Setter
@ToString
public class DepartmentRes {
    private long seq;
    private String name;

    public DepartmentRes(Department entity) {
        this.seq = entity.getSeq();
        this.name = entity.getName();
    }
}
