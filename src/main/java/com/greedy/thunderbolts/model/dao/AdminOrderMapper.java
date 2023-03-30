package com.greedy.thunderbolts.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dto.AdminBuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.AdminOrderDTO;
import com.greedy.thunderbolts.model.dto.AdminSellingOrdersDTO;

@Mapper
public interface AdminOrderMapper {

	int selectTotalCount(Map<String, String> searchMap);

	

	List<AdminOrderDTO> selectorderList(SelectCriteria selectCriteria);

	List<AdminSellingOrdersDTO> selectsellerList (SelectCriteria selectCriteria);
	
	List<AdminBuyingOrdersDTO> selectbuyerList (SelectCriteria selectCriteria);
	
	
	
}
