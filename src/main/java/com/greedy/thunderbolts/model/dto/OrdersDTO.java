package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrdersDTO {
	private int orderNo;
	private int memberBuyer;
	private int ordersPrice;
	private Date ordersDate;
	private String ordersDiv;
	private int sellingOrderNo;
	private int membersSeller;
	private String ordersStatus;
	private int buyingOrderCode;
	
   private int sellingOrderPrice;

   private String impUid;
   private String merchantUid;
   private String payDate;
   private int amount;
   private String cardType;
   private String refund;
   private int membersNo;

   public int getSellingOrderPrice() {
	  return sellingOrderPrice;
   }

   public void setSellingOrderPrice(int sellingOrderPrice) {
	  this.sellingOrderPrice = sellingOrderPrice;
   }

}