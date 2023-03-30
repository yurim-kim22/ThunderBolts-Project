package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
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

	   public int getSellingOrderPrice() {
	      return sellingOrderPrice;
	   }

	   public void setSellingOrderPrice(int sellingOrderPrice) {
	      this.sellingOrderPrice = sellingOrderPrice;
	   }

}