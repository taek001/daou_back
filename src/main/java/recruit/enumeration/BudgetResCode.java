package recruit.enumeration;

import recruit.global.enumeration.ResCode;

public enum BudgetResCode implements ResCode {

  BUDGET_SAVE_FAILED("B_999", "예산 등록 실패"),
  BUDGET_NOT_FOUND_FOR_DELETION("B_998", "예산 내역을 찾을 수 없음."),
  BUDGET_DELETION_FAILED("B_997", "예산 삭제 실패"),
  BUDGET_EXIST("B_996", "예산 중복 등록"),
  DEPARTMENT_NOT_FOUND("B_995", "부서 찾을 수 없음"),
  ;


  private final String code;
  private final String msg;

  BudgetResCode(String code, String msg) {
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
