package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.ProductDTO;

public interface ListService {
   List<ProductDTO> findProduct();

List<ProductDTO> findSizePrice();
   
   
}
