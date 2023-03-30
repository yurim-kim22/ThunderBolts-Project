package com.greedy.thunderbolts.model.dto.mypageDTO;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.BrandDTO;
import com.greedy.thunderbolts.model.dto.DeliveryDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;

import lombok.Data;

@Data
public class DetailDTO {
	
	private int orderNo;
	private AttachmentFileDTO file;
	private BrandDTO brand;
	private ProductDTO product;
	private OrdersDTO order;
	private DeliveryDTO delivery;
	
}
