package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DeliverydeDTO {
	    private int deliveryNo;
	    private int ordersNo;
	    private String productName;
	    private String membersId;
	    private String membersName;
	    private String postAddmin;
	    private String postDiv;
	    
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date deliveryDeDate;
	    private String deliveryNum;
	    private String receiveState;
		
//		private SellingOrdersDTO sellingOrder;
}




