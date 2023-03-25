package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SellingOrdersDTO {
	private int sellingOrderNo;
	private int productOptionCode;
	private int membersNo;
	private Date sellingOrderDate;
	private int sellingOrderPrice;
	private String sellingOrderStatus;
	private Date sellingOrderCancellationDate;
	private Date sellingOrderSuccessingDate;

	private Date sellingOrderDeadlineDate;

}
