package com.greedy.thunderbolts.model.dto.mypageDTO;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;

import lombok.Data;

@Data
public class SellListDTO {

	private int orderNo;
	private AttachmentFileDTO file;
	private ProductDTO product;
	private OrdersDTO order;
}
