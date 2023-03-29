package com.greedy.thunderbolts.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.MainPageDTO;


@Mapper
public interface DetailMapper {

	MainPageDTO finddetailProductbyProductCode(int productCode);
	
	MainPageDTO finddetailProductbyProductCodeSell(int productCode);
	
}
