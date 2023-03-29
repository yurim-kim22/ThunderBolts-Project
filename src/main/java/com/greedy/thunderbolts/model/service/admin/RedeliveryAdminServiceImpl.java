package com.greedy.thunderbolts.model.service.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.admin.ReDeliveryAdminListMapper;
import com.greedy.thunderbolts.model.dto.ReDeliveryDeAdminDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedeliveryAdminServiceImpl implements RedeliveryAdminService {

	
	@Autowired
	ReDeliveryAdminListMapper reDeliveryAdminListMapper;
	
	@Override
	public ReDeliveryDeAdminDTO redeliveryadmin(String reOrderNumber) {
		
		log.info("service1 : {}",reOrderNumber);
		ReDeliveryDeAdminDTO relist= reDeliveryAdminListMapper.recomedelivery(reOrderNumber);
		
		log.info("service2 : {}",reOrderNumber);
		
		
		return relist;
	}

}
