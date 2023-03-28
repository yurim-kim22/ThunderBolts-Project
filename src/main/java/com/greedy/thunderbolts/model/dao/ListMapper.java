package com.greedy.thunderbolts.model.dao;


import java.util.List;

import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ListMapper {
	   List<ProductDTO> findProduct();
	   
	   List<ProductDTO> findSizePrice();



	ProductDTO findSellingProduct(int sellingOrderNo);

	ProductOptionDTO findSellingProduct2(int sellingOrderNo);

    ProductDTO findSellingProduct(String productOptionSize);

	ProductDTO findProductOptionSize(String productOptionSize);

	List<ProductDTO> finalBuyBidOrderPage();

	List<ProductDTO> allFinalBuyBidOrderPage();

//	//주소록 인서트
//	int insertAddress(@Param("address") AddressDTO address , @Param("memberNo") int memberNo);
//	//주소록 조회
//	List<AddressDTO> selectAddress(int memberNo);

//	ProductOptionDTO selectProductBySizeAndCode(int buyingOrderPrice);
//	//프로젝트 옵션사이즈랑, 바잉프라이즈, 마감기한 날짜
//
//	ProductDTO selectProductBySizeAndCode1(int buyingOrderPrice);
}
