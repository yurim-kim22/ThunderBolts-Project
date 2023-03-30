package com.greedy.thunderbolts.model.dto.mypageDTO;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.BrandDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;

import lombok.Data;

@Data
public class WishDTO { //INTEREST테이블의 프로덕트 코드가 기준
	
	private int productCode;
	private AttachmentFileDTO file;
	private BrandDTO brand;
	private ProductDTO product;
}
