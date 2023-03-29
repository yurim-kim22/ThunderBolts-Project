package com.greedy.thunderbolts.model.dao.admin;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.ReDeliveryDeAdminDTO;

@Mapper
public interface ReDeliveryAdminListMapper {
	
	ReDeliveryDeAdminDTO recomedelivery(String reOrderNumber);
	
	

}
