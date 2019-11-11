package com.gdn.cairo.core.entity;

import com.gdn.cairo.core.utilities.enums.GoodsPurchaseRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Charlie Leonardo Oroh
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goods_purchase_request")
public class GoodsPurchaseRequest {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @Column(name = "code")
  private String code;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private GoodsPurchaseRequestStatus status;

  @Column(name = "type")
  private String type;

  @Column(name = "warehouse")
  private String warehouse;

  @OneToMany(mappedBy = "goods_purchase_request", fetch = FetchType.LAZY)
  @Column(name = "goods_purchase_request_item")
  private List<GoodsPurchaseRequestItem> goodsPurchaseRequestItems;

  @OneToMany(mappedBy = "goods_purchase_request", fetch = FetchType.LAZY)
  @Column(name = "goods_purchase_request_history")
  private List<GoodsPurchaseRequestHistory> goodsPurchaseRequestHistories;
}
