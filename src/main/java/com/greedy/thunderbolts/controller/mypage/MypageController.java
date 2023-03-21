package com.greedy.thunderbolts.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	//마이페이지 메인
	@GetMapping
	public String mypageMain(){
		
		return "mypage/mypageMain";
	}
	
	
	//마이페이지 관심상품
	@GetMapping("/wish")
	public String wish(){
		
	return "mypage/wish";
	}
}
