package com.greedy.thunderbolts.model.service.admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.DeliveryListMapper;
import com.greedy.thunderbolts.model.dto.DeliveryDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	DeliveryListMapper dliveryListMapper;
	@Override
	public List<DeliveryDTO> searchdelivery(String bh) {
		
		List<DeliveryDTO> list= deliveryListMapper.searchdelivery(bh);
		
		log.info("service : {}",list);
		
		//dao 호출 
		return list;
		// TODO Auto-generated method stub
		
	}
	
	

}
