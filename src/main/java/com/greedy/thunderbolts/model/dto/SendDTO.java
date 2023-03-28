package com.greedy.thunderbolts.model.dto;

public class SendDTO {
	
	private int productCode;

	public SendDTO(int productCode) {
		super();
		this.productCode = productCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "SendDTO [productCode=" + productCode + "]";
	}
	
	

}
