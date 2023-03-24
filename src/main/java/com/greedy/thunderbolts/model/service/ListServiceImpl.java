package com.greedy.thunderbolts.model.service;

import java.util.List;

import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.model.dao.ListMapper;
import com.greedy.thunderbolts.model.dto.ProductDTO;


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



}
