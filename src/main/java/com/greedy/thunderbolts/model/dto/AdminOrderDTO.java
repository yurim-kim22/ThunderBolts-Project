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
		private List<ProductDTO> product;
		private List<DeliveryDTO> delivery;
		private BuyingOrdersDTO buyingOrdersDTO;
		private SellingOrdersDTO	sellingOrdersDTO;
		private MembersDTO members;
	
	
}
