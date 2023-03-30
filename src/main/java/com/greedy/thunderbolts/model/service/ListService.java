package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.PaymentDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;

public interface ListService {
   List<ProductDTO> findProduct(int productCode);

   List<ProductDTO> findSizePrice(int productCode);

   ProductDTO findSellingProduct(int sellingOrderNo);

ProductOptionDTO findSellingProduct2(int sellingOrderPrice);

    //셀링오더프로덕트 찾기
    ProductDTO findSellingProduct(String productOptionSize);
    //옵션사이즈 찾기
    ProductDTO findProductOptionSize (String productOptionSize,int productCode);

    ProductDTO findBuyingProduct(int buyingOrderCode);
    
    ProductDTO findProductOptionSizeSell(String productOptionSize,int productCode);
  


    //바잉오더 주문
    List<ProductDTO> finalBuyBidOrderPage();
    //모든바잉오더 주문 조회
    List<ProductDTO> allFinalBuyBidOrderPage();
    
	//주소록 조회
	List<AddressDTO> selectAddress(int memberNo);

    List<ProductDTO> selectBuyingOrder(int productCode);

    List<BuyingOrdersDTO> selectBuyingOrderAll();
    
     
    
    //카드 결제 구매
	int buyInsertPay(PaymentDTO payment);
	//카드 결제 판매
	int sellInsertPay(String accountBank);
	//구매 오더
	OrdersDTO insertBuy(OrdersDTO ordersDTO);
	
	
	
	//멤버의 주소와 멤버 번호
	MembersDTO memberOrder(int memberNo);
	
	//멤버 계좌 조회 
	MembersDTO memberAccounts(int membersNo);
	
	
//    int insertAddress(@Param("address") AddressDTO address , @Param("memberNo") int memberNo);
//    //주소록 조회
//    List<AddressDTO> selectAddress(int memberNo);
}
