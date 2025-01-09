package recruit.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DisbursementStatusEnum {
    TEMP("임시저장"), WAITING("대기"), FIN("전송완료");

    private final String desc;
}
