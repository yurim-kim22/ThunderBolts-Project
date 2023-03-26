package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;

public interface ListService {
   List<ProductDTO> findProduct();

   List<ProductDTO> findSizePrice();

   ProductDTO findSellingProduct(int sellingOrderNo);

ProductOptionDTO findSellingProduct2(int sellingOrderPrice);


    ProductDTO findSellingProduct(String productOptionSize);

    ProductDTO findProductOptionSize (String productOptionSize);
    
    List<ProductDTO> finalBuyBidOrderPage();
    
    List<ProductDTO> allFinalBuyBidOrderPage();


//    ProductOptionDTO selectProductBySizeAndCode(int buyingOrderPrice);
    //프로젝트 옵션사이즈랑, 바잉프라이즈, 마감기한 날짜
//
//    ProductDTO selectProductBySizeAndCode1(int buyingOrderPrice);
}
