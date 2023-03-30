package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.PaymentDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.controller.buselllist.BuySellListController;
import com.greedy.thunderbolts.model.dao.ListMapper;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;

@Slf4j
@Service("listService")
@Transactional
public class ListServiceImpl implements ListService {
	
	private ListMapper listMapper;

	
	public ListServiceImpl (ListMapper listMapper) {

		this.listMapper = listMapper;
	}
	

	@Override
	public List<ProductDTO> findSizePrice(int productCode) {
		return listMapper.findSizePrice(productCode);
		
		
	}
	//바잉오더 조
	//
	@Override
	public  List<ProductDTO> selectBuyingOrder(int productCode){
		return listMapper.selectBuyingOrder(productCode);
	}

	@Override
	public List<BuyingOrdersDTO> selectBuyingOrderAll() {
		return listMapper.selectBuyingOrderAll();
	}


	@Override
	public List<ProductDTO> findProduct(int productCode) {

		return listMapper.findProduct(productCode);
	}
	
	


	@Override
	//findSellingProduc
	public ProductDTO findSellingProduct(int sellingOrderNo) {

		return listMapper.findSellingProduct(sellingOrderNo);
	}
	
	@Override
	public ProductDTO findProductOptionSizeSell(String productOptionSize) {
		return listMapper.findProductOptionSizeSell(productOptionSize);
	}
	
	
	@Override
	//findSellingProduc
	public ProductOptionDTO findSellingProduct2(int sellingOrderPrice) {
		return listMapper.findSellingProduct2(sellingOrderPrice);
	}
	public ProductDTO findSellingProduct(String productOptionSize) {

		return listMapper.findSellingProduct(productOptionSize);
	}

	@Override
	public ProductDTO findProductOptionSize(String productOptionSize) {
		
		log.info("productOptionSize: {} ",productOptionSize);
		return listMapper.findProductOptionSize(productOptionSize);
	}
	
	public ProductDTO findBuyingProduct(int buyingOrderCode) {
		return listMapper.findBuyingProduct(buyingOrderCode);
	}



	@Override
	public List<ProductDTO> finalBuyBidOrderPage() {
		// TODO Auto-generated method stub
		return listMapper.finalBuyBidOrderPage();
	}


	@Override
	public List<ProductDTO> allFinalBuyBidOrderPage() {
		// TODO Auto-generated method stub
		
		return listMapper.allFinalBuyBidOrderPage();
	}
	
	//주소록 조회
		@Override
		public List<AddressDTO> selectAddress(int memberNo) {
			return listMapper.selectAddress(memberNo);
		}
	//주문에서 넘길 데이터들 
		@Override
		public int buyInsertPay(PaymentDTO payment) {
			return listMapper.buyInsertPay(payment);
		}
		
		@Override
		public int sellInsertPay(String accountBank) {
			return listMapper.sellInsertPay(accountBank);
		}
		
		@Override
		public OrdersDTO insertBuy(OrdersDTO ordersDTO) {
			return listMapper.insertBuy(ordersDTO);
		}


		@Override
		public MembersDTO memberOrder(int memberNo) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public MembersDTO memberAccounts(int membersNo) {
			// TODO Auto-generated method stub
			return null;
		}
		
//		public 	MembersDTO memberOrder(int memberNo) {
//			return listMapper.memberOrder(memberNo);
//		}
		
//		//멤버 계좌 조회 
//		public MembersDTO memberAccounts(int membersNo) {
//			return listMapper.memberAccounts(membersNo);
//		}

	

}
