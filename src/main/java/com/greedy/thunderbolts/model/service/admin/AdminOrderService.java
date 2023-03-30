package com.greedy.thunderbolts.model.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.common.paging.Pagenation;
import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dao.AdminOrderMapper;
import com.greedy.thunderbolts.model.dto.AdminOrderDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AdminOrderService {
	
	private final AdminOrderMapper orderMapper;
	
	public AdminOrderService(AdminOrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	public Map<String, Object> selectOrderList(Map<String, String> searchMap, int page){
		
		int totalCount = orderMapper.selectTotalCount(searchMap);
		log.info("[AdminOrderService] totalCount : {}" , totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[BoardService] selectCriteria : {}", selectCriteria);	
		
		List<AdminOrderDTO> orderList = orderMapper.selectorderList(selectCriteria);
		log.info("[AdminOrderService] orderList : {}" , orderList);
		
		Map<String, Object> orderListAndPaging = new HashMap<>();
		orderListAndPaging.put("paging", selectCriteria);
		orderListAndPaging.put("orderList", orderList);
		
		return orderListAndPaging;
	}
	
	
	public List<AdminOrderDTO> findbyBuyer() {
	
		return null;
	}

public List<AdminOrderDTO> findbySeller() {
	
	return null;
}

public Map<String, Object> selectBuyerList(Map<String, String> searchMap, int page) {

	return null;
}
	
	

}
