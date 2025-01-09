package recruit.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyTypeEnum {
  KRW("원화(₩)"), JPY("엔화(¥)"), USD("달러($)");

  private final String desc;
}
