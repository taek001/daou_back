package recruit.enumeration;

import recruit.global.enumeration.ResCode;

public enum DisbursementResCode implements ResCode {

  DISBURSEMENT_SAVE_FAILED("B_999", "예산 등록 실패")
  ;


  private final String code;
  private final String msg;

  DisbursementResCode(String code, String msg) {
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
