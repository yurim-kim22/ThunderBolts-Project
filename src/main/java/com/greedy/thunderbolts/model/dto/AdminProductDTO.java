package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class AdminProductDTO {
	
	    private int productCode;
	    private String productName;
	    private String productNameKr;
	    private Date productEntryDate;
	    private int categoriesCode;
	    private int brandNo;
	    private int productCount;
		private List<ProductOptionDTO> productOption;
		private BrandDTO brand;
		private CategoriesDTO categories;
		public void setwriter(MembersDTO member) {
		
			
		}
}
