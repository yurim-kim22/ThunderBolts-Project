package com.greedy.thunderbolts.model.service.admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.admin.DeliveryDeAdminListMapper;
import com.greedy.thunderbolts.model.dto.DeliveryDeAdminDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliveryDeAdminServiceImpl implements DeliveryDeAdminService {
	
	@Autowired
	DeliveryDeAdminListMapper deliveryDeAdminListMapper;
	
	@Override
	public DeliveryDeAdminDTO deliverydeadmin (String orderNo){
		

		DeliveryDeAdminDTO delist= deliveryDeAdminListMapper.comedelivery(orderNo);
		
		log.info("service : {}",delist);
		
		return delist;
			
		
	}
	

	

	
}
