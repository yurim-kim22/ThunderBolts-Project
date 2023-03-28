package com.greedy.thunderbolts.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.main.MainService;

@Controller
public class MainController {
	
	private MainService mainService;
	
	public MainController (MainService mainService){
		this.mainService = mainService;
	}
	
	@GetMapping("/")
	public String main() {
		
	
		
		
		return "main";
	}
	
	

}

