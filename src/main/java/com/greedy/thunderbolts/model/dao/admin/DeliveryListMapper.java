package com.greedy.thunderbolts.model.dao.admin;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.DeliverydeDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;



@Mapper //mapper로 하여금  mapper폴더에 deliverydelistMapper 랑 같은 것과 매핑하는 것이다. 
//mapper에 있는 쿼리문이 실행되고 ,    select 값인 경우 list 로 반환된다. 
public interface DeliveryListMapper {
	   List<DeliverydeDTO> searchdelivery(String bh);
	   //이 매소드가 매칭이 되어 mapper에서 형성되어 반환한다고 생각하면 된다..(맞는지는 모르겠지만) 
	   
	   
	

	
}
