package com.greedy.thunderbolts.model.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.common.paging.Pagenation;
import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dao.AdminProductMapper;
import com.greedy.thunderbolts.model.dto.AdminProductDTO;
import com.greedy.thunderbolts.model.dto.AdminProductOptionDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AdminProductService {
	
	private final AdminProductMapper productMapper;
	
	public AdminProductService(AdminProductMapper productMapper) {
		this.productMapper = productMapper;
	};
	
public Map<String, Object> selectProductList(Map<String, String> searchMap, int page){
		
		int totalCount = productMapper.selectTotalCount(searchMap);
		log.info("[AdminproductService] totalCount : {}" , totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[BoardService] selectCriteria : {}", selectCriteria);	
		
		List<AdminProductDTO> productList = productMapper.selectProductList(selectCriteria);
		log.info("[AdminproductService] productList : {}" , productList);
		
		Map<String, Object> productListAndPaging = new HashMap<>();
		productListAndPaging.put("paging", selectCriteria);
		productListAndPaging.put("productList", productList);
		
		return productListAndPaging;
	}
	


public Map<String, Object> selectProductOptionList(Map<String, String> searchMap, int page){
	
	int totalCount = productMapper.selectTotalCount(searchMap);
	log.info("[AdminproductService] totalCount : {}" , totalCount);
	
	int limit = 10;
	
	int buttonAmount = 5;
	
	SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
	log.info("[BoardService] selectCriteria : {}", selectCriteria);	
	
	List<AdminProductOptionDTO> productOptionList = productMapper.selectProductOptionList(selectCriteria);
	log.info("[AdminproductService] productOptionList : {}" , productOptionList);
	
	Map<String, Object> productOptionListAndPaging = new HashMap<>();
	productOptionListAndPaging.put("paging", selectCriteria);
	productOptionListAndPaging.put("productOptionList", productOptionList);
	
	return productOptionListAndPaging;
}

}
