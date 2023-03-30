package com.greedy.thunderbolts.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greedy.thunderbolts.model.dto.DeliveryDeAdminDTO;
import com.greedy.thunderbolts.model.service.admin.DeliveryDeAdminService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class DeliveryDeAdminController {

	
	@Autowired
	DeliveryDeAdminService deliveryDeAdminImpl;
	
	@GetMapping("admin/deliverydeadmin")// url이 비동기 이기 때문에 브라우저상 url이 바뀌어 보이지 않는다.
	public Map<String, DeliveryDeAdminDTO > deliverydeadmin(@RequestParam("orderNo") String orderNo,HttpServletRequest request) {
		
		log.info("controller : {}",orderNo);
		
		DeliveryDeAdminDTO delist=deliveryDeAdminImpl.deliverydeadmin(orderNo);
		
	
		
		  Map<String, DeliveryDeAdminDTO > mapdelist= new HashMap<>();
		  mapdelist.put("mapdelistkey", delist); //,maplist라는 map에 deliveryde DTO객체들을 가지고 있는 list라는 이름의 list가 maplistkey라는 이름으로  들어있다. 
			
		  return mapdelist;
	 
	
	
}
}
