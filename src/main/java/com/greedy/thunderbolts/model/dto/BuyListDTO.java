package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BuyListDTO {

	private String productName;
	private Date orderDate;
	private String orderStatus;
	
}
