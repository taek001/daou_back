package recruit.global.model;

import lombok.*;
import recruit.global.enumeration.CommonResCode;
import recruit.global.enumeration.ResCode;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiRes<T> {

  private ApiResStatus result;

  private T data;

  public ApiRes(boolean success, T data) {
    this.result = ApiResStatus.builder().success(success).build();
    this.data = data;
  }


  public ApiRes(CommonResCode resCode) {
    this.result = ApiResStatus.builder()
      .success(false)
      .code(resCode.code())
      .message(result.getMessage())
      .build();
  }
}
