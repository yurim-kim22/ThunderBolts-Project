package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CheckingDTO {
	
	private int checkingNo;
	private int ordersNo;
	private String checkingStat;
	private String checkingResult;
	private Date checkingDate;
}
