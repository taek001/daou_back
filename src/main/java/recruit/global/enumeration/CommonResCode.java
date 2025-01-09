package recruit.global.enumeration;
import recruit.global.enumeration.ResCode;

public enum CommonResCode implements ResCode {

  MISSING_PATH_VARIABLE_EXCEPTION("GE900", "요청 정보가 잘못되었습니다."),
  CONSTRAINT_VIOLATION_EXCEPTION("GE901", "잘못된 요청입니다."),
  MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION("GE902", "요청 정보가 잘못되었습니다."),
  HTTP_MESSAGE_NOT_READABLE_EXCEPTION("GE903", "요청 정보가 잘못되었습니다."),
  METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION("GE904", "요청 정보가 잘못되었습니다."),
  NOT_FOUND_INSURANCE_TO_APPLY("GE905", "적용 가능한 보험을 찾지 못하였습니다."),
  NOT_FOUND_CAR_LIST("GE906","조회가능한 차량을 찾지 못하였습니다."),

  DUPLICATE_KEY_EXCEPTION("GE907", "데이터 중복 오류"),
  ENTITY_NOT_FOUND_EXCEPTION("GE908", "데이터를 찾을 수 없습니다."),
  SQL_EXCEPTION("GE909", "DB ERROR"),
  NULL_POINT_EXCEPTION("GE910", "NOT FOUND"),
  ;


  private final String code;
  private final String msg;

  CommonResCode(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String msg() {
    return msg;
  }

  @Override
  public String code() {
    return code;
  }

}
