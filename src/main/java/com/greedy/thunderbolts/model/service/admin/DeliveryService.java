package com.greedy.thunderbolts.model.service.admin;

import java.util.List;

import com.greedy.thunderbolts.model.dto.DeliveryDTO;

public interface DeliveryService {

	List<DeliveryDTO> searchdelivery(String bh);
	

}
