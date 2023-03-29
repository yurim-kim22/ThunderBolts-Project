package com.greedy.thunderbolts.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.main.MainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	private MainService mainService;
	
	public MainController (MainService mainService){
		this.mainService = mainService;
	}
	
	@GetMapping("/")
	public String main(Model model) {
		
		List<ProductDTO> newProductList = mainService.findNewProduct();
		log.info("[ControllerMain newProduct : {}",newProductList);
		
		log.info("[ControllerMain {} : " , newProductList);
	
		model.addAttribute("newProductList",newProductList);
		
		return "main";
	}
	
	

}

