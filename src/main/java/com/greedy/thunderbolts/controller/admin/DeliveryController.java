package com.greedy.thunderbolts.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greedy.thunderbolts.model.dto.DeliverydeDTO;
import com.greedy.thunderbolts.model.service.admin.DeliveryService;

//http 바디에 담아서 보낸다. 
@RestController
public class DeliveryController {

@Autowired	
DeliveryService deliveryServiceImpl;


@GetMapping("admin/searchdelivery")// url이 비동기 이기 때문에 브라우저상 url이 바뀌어 보이지 않는다.
public Map<String, List<DeliverydeDTO> > searchdelivery(@RequestParam("bh") String bh,HttpServletRequest request) {
 
    //String bh =request.getParameter("bh");
    
    List<DeliverydeDTO> list=deliveryServiceImpl.searchdelivery(bh);
    
    System.out.println(bh);
    
    for(int i=0; i<list.size() ; i++) {
     System.out.println(list.get(i));
    }
	/* 화면단으로 넘기기 위해서는 json 통신을 해서(키와 벨류값)으로 형식을 가지고 있어야 하고 그래야 자바스크립트로 넘길수 있는ㄷ
	 * list 는 키와 벨류가 아니기 떄문에 (객체를 담고 있는 리스트) -> 가공의 작업이 필요하다. list를 value를 가지는 키값을 주어야 한다.
	 * 그것을 위해서 aj*/
    
    Map<String, List<DeliverydeDTO> > maplist= new HashMap<>();
    maplist.put("maplistkey", list); //,maplist라는 map에 deliveryde DTO객체들을 가지고 있는 list라는 이름의 list가 maplistkey라는 이름으로  들어있다. 
	return maplist;
	


}





}
