package com.greedy.thunderbolts.controller.buselllist;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.SendDTO;
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
		 //컨트롤러는 이렇습니다 아래모델 뷰있는데 다 안들어가
	    ProductDTO findSellingProduct = listService.findSellingProduct(sellingOrderNo);

//	    System.out.println(send.toString());
	    //productName,productNameKr,productCode 입니당!!
	    
	    // 뷰에서 사용할 모델 객체에 데이터 추가
	    model.addAttribute("productDTO", findSellingProduct);
	    model.addAttribute("sellingOrderNo", sellingOrderNo);
	    model.addAttribute("sellingOrderPrice", sellingOrderPrice); //여 주석을 풀면 에러떠
	    model.addAttribute("productCode", findSellingProduct.getProductCode()); //이
	    model.addAttribute("productName", findSellingProduct.getProductName()); //이거
	    model.addAttribute("productNameKr", findSellingProduct.getProductNameKr());//이
	    model.addAttribute("productOptionSize", findSellingProduct.getProductOption().get(0).getProductOptionSize());

	    return "orderPage/normalOrderPage";
	}
//	@PostMapping("/buyBidOrderPage")
//	public String buyBidOrderPage(@RequestParam("buyingOrderPrice") int buyingOrderPrice,
//									@RequestParam("buyingOrderDeadlineDate") Date buyingOrderDeadlineDate,
//									Model model) {
	@PostMapping("/buyBidOrderPage")
	public String buyBidOrderPage(@RequestParam("buyingOrderPrice") int buyingOrderPrice ,
			 @RequestParam("buyingOrderDeadlineDate") Date buyingOrderDeadlineDate,
			 ProductDTO productDTO,
			 Model model) {
 	
		
		log.info("입찰 구매로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);
		log.info("입찰 구매로 넘어왔음: buyingOrderDeadlineDate={}", buyingOrderDeadlineDate);
		log.info("productDTO: productDTO={}", productDTO);
		//log.info("AllFinalBuyBidOrderPage:{}", AllFinalBuyBidOrderPage);
		//List<ProductDTO> productSize =listService.findSizePrice();
		// List<ProductDTO> finalBuyOrder =listService.finalBuyBidOrderPage();
//정처기 ->ㅠㅠ 대기업 중견(코딩테스트?ㅠㅠ
//		 model.addAttribute("ProductDTO",finalBuyOrder);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//List<ProductDTO> AllFinalBuyBidOrderPage =listService.allFinalBuyBidOrderPage();

		model.addAttribute("productCode", productDTO.getProductCode());
		model.addAttribute("productName", productDTO.getProductName());
		//죄송해용 여기네요 ㅠ
		//   //productName,productNameKr,productCode 입니당!!
		
		 model.addAttribute("buyingOrderPrice",buyingOrderPrice);
		 model.addAttribute("buyingOrderDeadlineDate",sdf.format(buyingOrderDeadlineDate));
		// model.addAttribute("AllFinalBuyBidOrderPage",AllFinalBuyBidOrderPage);
		   
//		   return "";
		    return "orderPage/buyBidOrderPage";
	}
	
	@PostMapping("/succedOrderComplite")
	public String Complite() {
		//log.info("완: buyingOrderPrice={}", buyingOrderPrice);
		//log.info("입찰 구매로 넘어왔음: buyingOrderDeadlineDate={}", buyingOrderDeadlineDate);
		return "agreeAtc/orderCompliete";
	}
	
	
	

}