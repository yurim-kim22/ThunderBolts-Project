package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import org.apache.ibatis.annotations.Param;

public interface ListService {
	//역할
	//컨트롤러(페이지 유알 처리해서 데이터 가져와서후에 넘겨주는 일)
	//,매퍼(데이터를가져올때),서비스(비지니스)
	//
   List<ProductDTO> findProduct();

   List<ProductDTO> findSizePrice();

   ProductDTO findSellingProduct(int sellingOrderNo);

ProductOptionDTO findSellingProduct2(int sellingOrderPrice);

    //셀링오더프로덕트 찾기
    ProductDTO findSellingProduct(String productOptionSize);
    //옵션사이즈 찾기
    ProductDTO findProductOptionSize (String productOptionSize);

    ProductDTO findBuyingProduct(int buyingOrderCode);
  


    //바잉오더 주문
    List<ProductDTO> finalBuyBidOrderPage();
    //모든바잉오더 주문 조회
    List<ProductDTO> allFinalBuyBidOrderPage();
    
	//주소록 조회
	List<AddressDTO> selectAddress(int memberNo);

    List<ProductDTO> selectBuyingOrder();

    List<BuyingOrdersDTO> selectBuyingOrderAll();
//    int insertAddress(@Param("address") AddressDTO address , @Param("memberNo") int memberNo);
//    //주소록 조회
//    List<AddressDTO> selectAddress(int memberNo);
}
