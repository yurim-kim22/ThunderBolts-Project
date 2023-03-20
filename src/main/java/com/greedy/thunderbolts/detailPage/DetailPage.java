package com.greedy.thunderbolts.detailPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class DetailPage {
	
	@GetMapping("/main")
	public String DetailPageMain() {
		
		return "/detail/detailMain";
	}
	

}
