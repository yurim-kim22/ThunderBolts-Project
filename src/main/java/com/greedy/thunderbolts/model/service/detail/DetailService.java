package com.greedy.thunderbolts.model.service.detail;

import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.DetailMapper;
import com.greedy.thunderbolts.model.dto.MainPageDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DetailService {
	
	
	private final DetailMapper mapper;
	
	public DetailService(DetailMapper mapper) {
		this.mapper = mapper;
	}

	public MainPageDTO finddetailProductbyProductCode(int ProductCode) {
		
		log.info("[detail service] ProductCode : {}", ProductCode);
		
		MainPageDTO ProductList = mapper.finddetailProductbyProductCode(ProductCode);
		
	log.info("[detail service] ProductList : {}", ProductList);
	
		return ProductList;
	}

	
	

}
