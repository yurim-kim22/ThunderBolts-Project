package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	private int productCode;
	private String productName;
	private Date productEntryDate;
	private int categoriesCode;
	private int productPrice;
	private int brandNo; 
}
