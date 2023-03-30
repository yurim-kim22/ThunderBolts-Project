package com.greedy.thunderbolts.model.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.admin.DeliveryDeAdminInsertMapper;
import com.greedy.thunderbolts.model.dto.DeliveryDeAdminInsertDTO;

@Service
public class DeliveryDeAdminInsertServiceImpl implements DeliveryDeAdminInsertService {
	
	@Autowired
	DeliveryDeAdminInsertMapper deliveryDeAdminInsertMapper;
	
	@Override
	public int deliverydeadmin(DeliveryDeAdminInsertDTO insert) {
				
		int deinsert= deliveryDeAdminInsertMapper.insertMapper(insert);
		
		
		return deinsert;
	}
	
	

}
