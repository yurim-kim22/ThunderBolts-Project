package com.greedy.thunderbolts.controller.buselllist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/list")
public class BuySellListController {
	
	private ListService listService;
	
	public BuySellListController(ListService listService) {
		this.listService= listService;
	}
	
	@GetMapping("/index")
	public String productList(Model model) {
		List<ProductDTO> productList = listService.findProduct();
		
		log.info("productList : {}", productList);
		model.addAttribute("productList",productList);
		
		List<ProductDTO> productSize =listService.findSizePrice();
		
		log.info("productSize: {}", productSize);
		model.addAttribute("pproductSize",productSize);
		
		
		//호출 해L
		return "product/list";
	}
	
	@GetMapping("/normalBuy")
	public String normalBuy(Model model){
		List<ProductDTO> productList = listService.findProduct();
		
		
		//로그찍어보기
		log.info("productList : {}", productList);
		
		//
		model.addAttribute("productList",productList);
		
		List<ProductDTO> productSize =listService.findSizePrice();
		
		log.info("productSize: {}", productSize);
		model.addAttribute("pproductSize",productSize);

		return "product/normalBuy";
		
	}
	@PostMapping("/normalBuy")
	public String normalBuy(@RequestParam("productCode") int productCode,
	                        @RequestParam("productName") String productName,
	                        @RequestParam("productNameKr") String productNameKr,
	                        @RequestParam("productOptionSize") String productOptionSize,
	                        @RequestParam("productPrice") int productPrice,
	                       	Model model) {
	    log.info("Selected product information : productCode={}, productName={}, productNameKr={},productOptionSize={},productPrice={}",
	             productCode, productName, productNameKr, productOptionSize,productPrice);
	    
	    model.addAttribute("productCode", productCode);
	    model.addAttribute("productName", productName);
	    model.addAttribute("productNameKr", productNameKr);
	    
	    //여기를이렇게적어야할까요 
	    return "agreeAtc/buyAgree";
	    
	    //아니면 이렇게 리 다이렉트로 해야할까요...??
//	    return "redirect:/list/buyAgree";
	}

	@GetMapping("/buyAgree")
	public String buyAgree() {
	    return "agreeAtc/buyAgree";
	}
	
    
	
	@GetMapping("/normalSell")
	public String normalSell(){
		return "product/normalSell";
		
	}
	
	@GetMapping("/oneSizeBuying")
	public String oneSizeBuying(){
		return "product/oneSizeBuying";
		
	}
	
	@GetMapping("/oneSizeSelling")
	public String oneSizeSelling(){
		return "product/oneSizeSelling";
		
	}
	
//	@GetMapping("/buyAgree")
//	public String buyAgree(){
//		return "agreeAtc/buyAgree";
//		
//	}
	
	@GetMapping("/sellAgree")
	public String sellAgree(){
		return "agreeAtc/sellAgree";
		
	}
	
	@GetMapping("/buyBid")
	public String buyBid(){
		return "bid/buyBid";
		
	}
	
	
	@GetMapping("/sellBid")
	public String sellBid(){
		return "bid/sellBid";
		
	}


}
