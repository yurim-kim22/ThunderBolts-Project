package com.greedy.thunderbolts.model.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.DeliveryDeAdminDTO;
import com.greedy.thunderbolts.model.service.admin.DeliveryDeAdminService;

@Mapper
public interface DeliveryDeAdminListMapper {

	DeliveryDeAdminDTO comedelivery(String orderNo);

	DeliveryDeAdminDTO insertdelivery(String orderNo);

}
