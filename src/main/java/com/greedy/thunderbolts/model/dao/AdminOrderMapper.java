package com.greedy.thunderbolts.model.dao;

import java.util.List;
import java.util.Map;

import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dto.AdminOrderDTO;

public interface AdminOrderMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<AdminOrderDTO> selectbuyerList(SelectCriteria selectCriteria);

	List<AdminOrderDTO> selectorderList(SelectCriteria selectCriteria);

	
	
}
