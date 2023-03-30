package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AdminOrderDTO {


	
		private int ordersNo;
		private int memberBuyer;
		private int ordersPrice;
		private Date ordersDate;
		private String ordersDiv;
		private int sellingOrderNo;
		private int membersSeller;
		private String ordersStatus;
		private int buyingOrderCode;
		private AdminProductDTO product;
		private AdminBuyingOrdersDTO buyingOrdersDTO;
		private AdminSellingOrdersDTO sellingOrdersDTO;
		private AdminMembersDTO members;
		
		
	
	
}
