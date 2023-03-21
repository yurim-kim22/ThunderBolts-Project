package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductOptionDTO {
	private int productCode;
	private int productOptionCode;
	private String productOptionColor;
	private String productOptionSize;
	private String productOptionEtc;
	private int prodcutOptionQuantitiy; 
}
