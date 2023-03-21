package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BuyListDTO {

//	private String filePath; 첨부파일
	private String productName;
	private Date orderDate;
	private String orderStatus;

	
}
