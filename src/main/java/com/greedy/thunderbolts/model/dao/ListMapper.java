package com.greedy.thunderbolts.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.PaymentDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;


@Mapper
public interface ListMapper {
	   List<ProductDTO> findProduct(int productCode);
	   
	   List<ProductDTO> findSizePrice(int productCode);

	   //바잉오더 조회
	   List<ProductDTO> selectBuyingOrder();

	   List<ProductDTO> findBuyingProduct();

	ProductDTO findSellingProduct(int sellingOrderNo);

	ProductOptionDTO findSellingProduct2(int sellingOrderNo);

    ProductDTO findSellingProduct(String productOptionSize);

	ProductDTO findProductOptionSize(String productOptionSize);
	
	ProductDTO findBuyingProduct(int buyingOrderCode);
	
	ProductDTO findProductOptionSizeSell(String productOptionSize);
	

	List<ProductDTO> finalBuyBidOrderPage();

	List<ProductDTO> allFinalBuyBidOrderPage();

	//주소록 조회
	List<AddressDTO> selectAddress(int memberNo);

	List<BuyingOrdersDTO> selectBuyingOrderAll();
	
	//주문    //카드 결제 구매
	int buyInsertPay(PaymentDTO payment);
	//카드 결제 판매
	int sellInsertPay(String accountBank);
	//구매 오더
	OrdersDTO insertBuy(OrdersDTO ordersDTO);
	//멤버의 주소와 멤버 번호
	List<MembersDTO> memberOrder(int memberNo);
	
	//멤버 계좌 조회 
	List<MembersDTO> memberAccounts(int membersNo);


//	//주소록 인서트
//	int insertAddress(@Param("address") AddressDTO address , @Param("memberNo") int memberNo);
//	//주소록 조회
//	List<AddressDTO> selectAddress(int memberNo);

//	ProductOptionDTO selectProductBySizeAndCode(int buyingOrderPrice);
//	//프로젝트 옵션사이즈랑, 바잉프라이즈, 마감기한 날짜
//
//	ProductDTO selectProductBySizeAndCode1(int buyingOrderPrice);
}
