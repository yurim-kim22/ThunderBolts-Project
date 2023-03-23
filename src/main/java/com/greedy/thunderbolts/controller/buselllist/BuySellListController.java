package com.greedy.thunderbolts.controller.buselllist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
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
	
	@PostMapping("/index")
	public String productList(
	    @RequestParam("sellingOrderNo") int sellingOrderNo,
	    Model model1) {
	    log.info("구매 요청: sellingOrderNo=" + sellingOrderNo); // 로그 출력
	    
	    // 구매 처리 로직 구현
	    
	    return "agreeAtc/buyAgree";
	}

	
	@GetMapping("/normalBuy")
	public String normalBuy(Model model){
		List<ProductDTO> productList = listService.findProduct();
		
		
		//로그찍어보기
		log.info("productList : {}", productList);
		
		for (ProductDTO product : productList) {
			log.info(product.toString());
			for (ProductOptionDTO option : product.getProductOption()) {
				log.info(option.getSellingOrders().toString());
			}
		}
		
		//
		model.addAttribute("productList",productList);
		
		List<ProductDTO> productSize =listService.findSizePrice();
		
		log.info("productSize: {}", productSize);
		model.addAttribute("pproductSize",productSize);

		return "product/normalBuy";
		
	}
	@GetMapping("/normalBuy2")
	public String normalBuy(
	                        @RequestParam("sellingOrderNo") int sellingOrderNo, //보내는 친구
	                        Model model) {
		System.out.println("구매 요청: sellingOrderNo=" + sellingOrderNo);
	    // 구매 처리 로직 구현
	    
	    return "agreeAtc/buyAgree";
	}
   // GET, POST 

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
