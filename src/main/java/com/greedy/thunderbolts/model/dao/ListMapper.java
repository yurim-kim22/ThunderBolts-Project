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

	ProductOptionDTO findSellingProduct2(int sellingOrderNo);

    ProductDTO findSellingProduct(String productOptionSize);

	ProductDTO findProductOptionSize(String productOptionSize);

//	ProductOptionDTO selectProductBySizeAndCode(int buyingOrderPrice);
//	//프로젝트 옵션사이즈랑, 바잉프라이즈, 마감기한 날짜
//
//	ProductDTO selectProductBySizeAndCode1(int buyingOrderPrice);
}
