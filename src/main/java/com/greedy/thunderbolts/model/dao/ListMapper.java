package com.greedy.thunderbolts.model.dao;


import java.util.List;

import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;
import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;



@Mapper
public interface ListMapper {
	   List<ProductDTO> findProduct();
	   
	   List<ProductDTO> findSizePrice();



	ProductDTO findSellingProduct(int sellingOrderNo);
}
