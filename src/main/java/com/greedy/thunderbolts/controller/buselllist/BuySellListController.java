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
		model.addAttribute("productSize",productSize);
		
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
		
		log.info("productList : {}", productList);
		
		for (ProductDTO product : productList) {
			log.info(product.toString());
			for (ProductOptionDTO option : product.getProductOption()) {
				log.info(option.getSellingOrders().toString());
			}
		}
		
		model.addAttribute("productList",productList);
		
		List<ProductDTO> productSize =listService.findSizePrice();
		
		log.info("productSize: {}", productSize);
		model.addAttribute("productSize",productSize);

		return "product/normalBuy";
		
	}
	
	//오더를 넘기는
	@GetMapping("/normalBuy2")
	public String normalBuy(
	                        @RequestParam("sellingOrderNo") int sellingOrderNo,
	                        Model model) {
		log.info("구매 요청: sellingOrderNo={}" + sellingOrderNo);
	    
	    // 구매 처리 로직 구현
	    
	    return "agreeAtc/buyAgree";
	}

	//이건 아직 안한거임
	@PostMapping("/normalSell")
	public String normalSell(Model model) {
	    // 로직 구현
	    return "product/normalSell";
	}

//
		
	@PostMapping("/normalOrderPage") 
	public String normalOrderPage(@RequestParam("sellingOrderNo") int sellingOrderNo, Model model) {
	    log.info("결제 요청: sellingOrderNo={}" + sellingOrderNo);
	    
	    // sellingOrderNo를 사용하여 ProductOption 객체를 불러온 후 모델에 추가하깅
	    //이 부분익 이게맞나/?
	    ProductOptionDTO productOption = listService.findProductOptionBySellingOrderNo(sellingOrderNo);
	    
//		List<ProductOptionDTO> productSize =listService.findProductOptionBySellingOrderNo(sellingOrderNo);
		
//	    model.addAttribute("findProductOptionBySellingOrderNo", findProductOptionBySellingOrderNo);

	    return "orderPage/normalOrderPage";
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
	

	
	@GetMapping("/buyBid")
	public String buyBid(){
		return "bid/buyBid";
		
	}
	
	
	@GetMapping("/sellBid")
	public String sellBid(){
		return "bid/sellBid";
		
	}


}
