package com.greedy.thunderbolts.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/menu")
public class ListController {
	
	private ListService listService;
	
	public ListController(ListService listService) {
		this.listService= listService;
	}
	
	@GetMapping("/list")
	public String productList(Model model) {
		List<ProductDTO> productList = listService.findProduct();
		
		log.info("productList : {}", productList);
		model.addAttribute("productList",productList);
		
		
		//호출 해L
		return "/product/index";
	}

}