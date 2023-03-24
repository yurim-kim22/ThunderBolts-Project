package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
	    private int productCode;
	    private String productName;
	    private String productNameKr;
	    private Date productEntryDate;
	    private int categoriesCode;
	    private int brandNo;
	    private int productCount;
		private List<ProductOptionDTO> productOption;

	// 추가된 메소드
	public String getProductOptionName() {
		return productOption.get(0).getProductOptionColor() + " / " + productOption.get(0).getProductOptionSize();
	}


}




