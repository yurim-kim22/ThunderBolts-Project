package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.model.dao.ListMapper;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;


@Service("listService")
@Transactional
public class ListServiceImpl implements ListService {
	
	private ListMapper listMapper;

	
	public ListServiceImpl (ListMapper listMapper) {

		this.listMapper = listMapper;
	}
	

	@Override
	public List<ProductDTO> findSizePrice() {
		return listMapper.findSizePrice();
		
		
	}


	@Override
	public List<ProductDTO> findProduct() {

		return listMapper.findProduct();
	}


	@Override
	//findSellingProduc
	public ProductDTO findSellingProduct(int sellingOrderNo) {

		return listMapper.findSellingProduct(sellingOrderNo);
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
		return listMapper.findProductOptionSize(productOptionSize);
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
		//계좌 조회

//	@Override
//	public int insertAddress(AddressDTO address, int memberNo) {
//
//		return ListMapper.insertAddress(address, memberNo);
//	}
//	//주소록 조회
//	@Override
//	public List<AddressDTO> selectAddress(int memberNo) {
//
//		return ListMapper.selectAddress(memberNo);
//	}
	//계좌 조회


//	@Override
//	public ProductOptionDTO selectProductBySizeAndCode(int buyingOrderPrice) {
//		return listMapper.selectProductBySizeAndCode(buyingOrderPrice);
//
//	}
//
//	@Override
//	public ProductDTO selectProductBySizeAndCode1(int buyingOrderPrice) {
//		return listMapper.selectProductBySizeAndCode1(buyingOrderPrice);
//
//	}
}
