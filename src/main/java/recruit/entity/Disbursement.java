package recruit.entity;

import jakarta.persistence.*;
import lombok.*;
import recruit.enumeration.CurrencyTypeEnum;
import recruit.enumeration.DisbursementStatusEnum;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disbursement")
public class Disbursement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "budget_seq")
  private Budget budget;

  @Column
  private String title;

  @Column
  @Enumerated(EnumType.STRING)
  private DisbursementStatusEnum status;

  @Builder.Default
  @OneToMany(mappedBy = "disbursement", cascade = CascadeType.ALL)
  private List<DisbursementItem> items = new ArrayList<>();

  public void addItem(DisbursementItem item) {
    this.items.add(item);
    item.setDisbursement(this);
  }

}
