package com.greedy.thunderbolts.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dto.AdminProductDTO;

@Mapper
public interface AdminProductMapper {

	
	int selectTotalCount(Map<String, String> searchMap);

	List<AdminProductDTO> selectProductList(SelectCriteria selectCriteria);
	
	
}
