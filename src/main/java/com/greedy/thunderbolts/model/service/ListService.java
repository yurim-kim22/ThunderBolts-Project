package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;

public interface ListService {
   List<ProductDTO> findProduct();

   List<ProductDTO> findSizePrice();

   ProductDTO findSellingProduct(int sellingOrderNo);

ProductOptionDTO findSellingProduct2(int sellingOrderPrice);




}
