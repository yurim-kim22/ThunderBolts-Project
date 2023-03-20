package com.greedy.thunderbolts.controller.buselllist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class BuySellListController {
	
	@GetMapping("/normalBuy")
	public String normalBuy(){
		return "productList/normalBuy";
		
	}
	@GetMapping("/normalSell")
	public String normalSell(){
		return "productList/normalSell";
		
	}
	
	@GetMapping("/oneSizeBuying")
	public String oneSizeBuying(){
		return "productList/oneSizeBuying";
		
	}
	
	@GetMapping("/oneSizeSelling")
	public String oneSizeSelling(){
		return "productList/oneSizeSelling";
		
	}
	
	@GetMapping("/buyAgree")
	public String buyAgree(){
		return "agreeAtc/buyAgree";
		
	}
	
	@GetMapping("/sellAgree")
	public String sellAgree(){
		return "agreeAtc/sellAgree";
		
	}

}
