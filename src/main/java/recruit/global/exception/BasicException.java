package recruit.global.exception;

import recruit.global.enumeration.ResCode;
import lombok.Getter;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;

@Getter
public class BasicException extends RuntimeException {

  private final String code;
  private final ResCode resCode;

  public BasicException(ResCode resCode) {
    super(resCode.msg());
    this.code = resCode.code();
    this.resCode = resCode;
  }

  public ApiRes<Void> toApiRes() {
    return ApiRes.<Void>builder()
            .result(ApiResStatus.builder().success(false).message(this.resCode.msg()).code(this.resCode.code()).build())
            .build();
  }
}
