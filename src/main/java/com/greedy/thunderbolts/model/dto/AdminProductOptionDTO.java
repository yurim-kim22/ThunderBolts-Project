package com.greedy.thunderbolts.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class AdminProductOptionDTO {
	
	private int productOptionCode;
	private int productCode;
	private String productOptionColor;
	private String productOptionSize;
	private String productOptionEtc;
	private int productOptionQuantitiy;
	private List<SellingOrdersDTO> sellingOrders;
	private List<BuyingOrdersDTO> buyingOrders;
	private AdminProductDTO product;

}
