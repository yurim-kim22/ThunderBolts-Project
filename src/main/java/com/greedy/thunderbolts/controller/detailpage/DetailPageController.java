package com.greedy.thunderbolts.controller.detailpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.MainPageDTO;
import com.greedy.thunderbolts.model.service.detail.DetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/detail")
public class DetailPageController {
	
	private DetailService detailService;
	
	public DetailPageController (DetailService detailService){
		this.detailService = detailService;
	}
	
	@GetMapping("/main")
	public String DetailPageMain(@RequestParam(value="proCode", required=false) String main, Model model) {
		
		log.info("[DetailPageController] : code {}", main);
		
		int ProductCode = Integer.parseInt(main);
		
		MainPageDTO productList = detailService.finddetailProductbyProductCode(ProductCode);
		log.info("[DetailPageController productList : {}",productList);
		
		
		model.addAttribute("productList",productList);
		 
		return "/detail/detailMain";
	}
	

}
