package com.greedy.thunderbolts.controller.buselllist;

import java.util.List;

import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orderPage")
public class OrderController {
	
	private ListService listService;
	
	public OrderController(ListService listService) {

		this.listService= listService;
	}


	
	@PostMapping("/normalOrderPage")
	public String normalOrderPage(@RequestParam("sellingOrderNo") int sellingOrderNo,
									@RequestParam("sellingOrderPrice") int sellingOrderPrice,
									Model model) {
		 log.info("결제요청으로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		 log.info("결제요청으로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);
		    
	    // sellingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회
	    ProductDTO findSellingProduct = listService.findSellingProduct(sellingOrderNo);


	    
	    // 뷰에서 사용할 모델 객체에 데이터 추가
	    model.addAttribute("productDTO", findSellingProduct);
	    model.addAttribute("sellingOrderNo", sellingOrderNo);
	    model.addAttribute("sellingOrderPrice", sellingOrderPrice); //여 주석을 풀면 에러떠
	    model.addAttribute("productCode", findSellingProduct.getProductCode());
	    model.addAttribute("productName", findSellingProduct.getProductName());
	    model.addAttribute("productNameKr", findSellingProduct.getProductNameKr());
	    model.addAttribute("productOptionSize", findSellingProduct.getProductOption().get(0).getProductOptionSize());

	    return "orderPage/normalOrderPage";
	}
}