package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

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
	private ProductDTO product;
	private List<DeliveryDTO> delivery;
	private BuyingOrdersDTO buying;
}
