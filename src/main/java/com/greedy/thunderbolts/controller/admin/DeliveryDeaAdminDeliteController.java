package com.greedy.thunderbolts.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greedy.thunderbolts.model.dto.DeliveryDeAdminDTO;
import com.greedy.thunderbolts.model.dto.DeliveryDeAdminInsertDTO;
import com.greedy.thunderbolts.model.service.admin.DeliveryDeAdminDeliteService;
import com.greedy.thunderbolts.model.service.admin.DeliveryDeAdminInsertService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class DeliveryDeaAdminDeliteController {
	
	
	@Autowired
	DeliveryDeAdminDeliteService deliveryDeAdminDeliteServiceImpl;
	
	@PostMapping("admin/deliverydelite")// url이 비동기 이기 때문에 브라우저상 url이 바뀌어 보이지 않는다.
	public Map<String, Integer > deliveryDeAdminInsert(@RequestBody DeliveryDeAdminInsertDTO delite){//@@RequestBody 입력된순간 키값이 자바에서는 필드가 되고  //보낸 json이 DTO에 필드값에 자동으로 같은 이름을 찾아서(json의 키값으로) 매핑해준다.
		
		// 그 객체 delite
		
        log.info("controller : {}",delite.getOrderNo());
		
          int success=deliveryDeAdminDeliteServiceImpl.deliverydelite(delite);//객체를 던진다.
          
          log.info("controller : {}",success);   //getter 꺼내는것(자바)
          log.info("controller : {}",delite.getOrderNo());
          
          
          Map<String, Integer > mapsuccess= new HashMap<>();  //Integer
          
          mapsuccess.put("suceesskey", success);
          
		
		return mapsuccess;   //백단에서 프론트 프론트에서 백단으로 갈떄는 json 의 형태로 간다. 
		
		
	}

}
