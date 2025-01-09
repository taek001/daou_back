package recruit.entity;

import jakarta.persistence.*;
import lombok.*;
import recruit.dto.DisbursementItemReq;
import recruit.enumeration.CurrencyTypeEnum;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disbursement_item")
public class DisbursementItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "disbursement_seq")
  private Disbursement disbursement;

  @Column
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "currency_type")
  private CurrencyTypeEnum currencyType;

  @Column(name = "exchange_rate")
  private Double exchangeRate;

  @Column
  private int quantity;

  @Column(name = "unit_price")
  private Double unitPrice;

  public DisbursementItem(DisbursementItemReq req) {
    this.name = req.getName();
    this.currencyType = req.getCurrencyType();
    this.exchangeRate = req.getExchangeRate();
    this.quantity = req.getQuantity();
    this.unitPrice = req.getUnitPrice();
  }
}
