package com.greedy.thunderbolts.controller.buselllist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuySellListController {
	
	@GetMapping("/list/normalBuy")
	public String normalBuy(){
		return "common/productList/normalBuy";
		
	}

}
