package com.greedy.thunderbolts.model.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.admin.DeliveryDeAdminDeliteMapper;
import com.greedy.thunderbolts.model.dto.DeliveryDeAdminInsertDTO;

@Service
public class DeliveryDeAdminDeliteServiceImpl implements DeliveryDeAdminDeliteService {
	
	@Autowired
	DeliveryDeAdminDeliteMapper deliveryDeAdminDeliteMapper;

	@Override
	public int deliverydelite(DeliveryDeAdminInsertDTO delite) {

		int dedelite=deliveryDeAdminDeliteMapper.deliteMapper(delite);
		
		return dedelite;
	}
	

}
