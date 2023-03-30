package com.greedy.thunderbolts.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.service.admin.AdminProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminProductController {
	
	private final AdminProductService productService;
	
	public AdminProductController(AdminProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/productMainPage")
	public String ProductList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String searchCondition, @RequestParam(required = false) String searchValue,
			Model model) {
		
		log.info("[AdminProductController] : page : {} " , page );
		
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		log.info("[AdminProductController] searchMap : {}", searchMap);

		Map<String, Object> ProductListAndPaging = productService.selectProductOptionList(searchMap, page);
		model.addAttribute("paging", ProductListAndPaging.get("paging"));
		model.addAttribute("productOptionList", ProductListAndPaging.get("productOptionList"));
		
		
		return "/admin/product/productMain";
		
	}
	
}
