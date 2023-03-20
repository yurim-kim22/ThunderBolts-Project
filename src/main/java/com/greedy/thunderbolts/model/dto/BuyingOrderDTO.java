package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyingOrderDTO {
	
	private int membersNo;
	private int productOptionCode;
	private int buyingOrderCode;
	private Date buyingOrderRegistDate;
	private int buyingOrderPrice;
	private String buyingOrderStatus;
	private Date buyingOrderCancellationDate;
	private Date buyingOrderSuccessingDate;
}
