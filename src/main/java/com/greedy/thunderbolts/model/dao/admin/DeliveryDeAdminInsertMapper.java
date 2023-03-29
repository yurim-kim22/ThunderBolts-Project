package com.greedy.thunderbolts.model.dao.admin;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.DeliveryDeAdminInsertDTO;

@Mapper
public interface DeliveryDeAdminInsertMapper {

	//mapper에서 쿼리문이 실행되면 select문을 제외하고는 int값이 온다. 
	
	
	
    int insertMapper(DeliveryDeAdminInsertDTO insert) ;

}
