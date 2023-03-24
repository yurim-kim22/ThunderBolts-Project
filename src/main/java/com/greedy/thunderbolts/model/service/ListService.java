package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;

public interface ListService {
   List<ProductDTO> findProduct();

List<ProductDTO> findSizePrice();

ProductOptionDTO findProductOptionBySellingOrderNo(int sellingOrderNo);
// ... 
   
}
