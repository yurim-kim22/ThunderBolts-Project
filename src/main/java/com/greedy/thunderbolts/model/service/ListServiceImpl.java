package com.greedy.thunderbolts.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.model.dao.ListMapper;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;


@Service("listService")
@Transactional
public class ListServiceImpl implements ListService {
	
	private final ListMapper listMapper;

	
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
	public ProductOptionDTO findProductOptionBySellingOrderNo(int sellingOrderNo) {
	    return listMapper.findProductOptionBySellingOrderNo(sellingOrderNo);
	}


}
