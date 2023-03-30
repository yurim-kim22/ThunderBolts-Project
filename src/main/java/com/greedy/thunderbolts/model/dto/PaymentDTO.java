package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentDTO {
	private int payWayNo;
	private String payWayName;
	private int ordersNo;
	private Date payDate;
}
