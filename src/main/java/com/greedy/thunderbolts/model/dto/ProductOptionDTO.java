package com.greedy.thunderbolts.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductOptionDTO {
    private int productOptionCode;
    private int productCode;
    private String productOptionColor;
    private String productOptionSize;
    private String productOptionEtc;
    private int productOptionQuantity; 
    private List<SellingOrdersDTO> sellingOrders;
    private List<BuyingOrdersDTO> buyingOrders;

    
}




