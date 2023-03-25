package com.greedy.thunderbolts.controller.buselllist;

import java.util.List;

import com.greedy.thunderbolts.model.dto.SellingOrdersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		List<ProductDTO> productSize =listService.findSizePrice();

		log.info("productList : {}", productList);
		log.info("productSize: {}", productSize);


		for (ProductDTO product : productList) {
			log.info(product.toString());
			for (ProductOptionDTO option : product.getProductOption()) {
				log.info(option.getSellingOrders().toString());
			}
		}

		//뷰에 보이는거

		model.addAttribute("productList",productList);
		model.addAttribute("productSize",productSize);

		return "product/normalBuy";
		
	}

	@GetMapping("/normalBuy2")
	public String normalBuy2(
			@RequestParam("sellingOrderNo") int sellingOrderNo,
			@RequestParam(value = "sellingOrderPrice", required = false) String sellingOrderPrice,
			Model model) {
		log.info("구매 요청 어그리로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("구매 요청 어그리로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);

		// sellingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회
		ProductDTO findSellingProduct = listService.findSellingProduct(sellingOrderNo);

		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productDTO", findSellingProduct);
		model.addAttribute("sellingOrderNo", sellingOrderNo);
		model.addAttribute("sellingOrderPrice", sellingOrderPrice);
		model.addAttribute("productCode", findSellingProduct.getProductCode());
		model.addAttribute("productName", findSellingProduct.getProductName());
		model.addAttribute("productNameKr", findSellingProduct.getProductNameKr());
		model.addAttribute("productOptionSize", findSellingProduct.getProductOption().get(0).getProductOptionSize());

		return "agreeAtc/buyAgree";
	}

	@GetMapping("/normalBuy3")
	public String normalBuy3(@RequestParam("productOptionSize") String productOptionSize,
							 Model model) {
//		log.info("구매 입찰로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("구매 입찰로 넘어왔음: productOptionSize={}", productOptionSize);

		// sellingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회
		ProductDTO findProductOptionSize = listService.findProductOptionSize(productOptionSize);



		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productDTO", findProductOptionSize);
		model.addAttribute("productCode", findProductOptionSize.getProductCode());
		model.addAttribute("productName", findProductOptionSize.getProductName());
		model.addAttribute("productNameKr", findProductOptionSize.getProductNameKr());
		model.addAttribute("productOptionSize", findProductOptionSize.getProductOption().get(0).getProductOptionSize());


		return "bid/buyBid";
	}










	//이건 아직 안한거임
	@PostMapping("/normalSell")
	public String normalSell(Model model) {
	    // 로직 구현
	    return "product/normalSell";
	}

//
		
//	@PostMapping("/normalOrderPage")
//	public String normalOrderPage(@RequestParam("sellingOrderNo") int sellingOrderNo, Model model) {
//	    log.info("결제 요청: sellingOrderNo={}" + sellingOrderNo);
//
//	    // sellingOrderNo를 사용하여 ProductOption 객체를 불러온 후 모델에 추가하깅
//	    //이 부분익 이게맞나/?
//	    ProductOptionDTO productOption = listService.findProductOptionBySellingOrderNo(sellingOrderNo);
//
////		List<ProductOptionDTO> productSize =listService.findProductOptionBySellingOrderNo(sellingOrderNo);
//
//
//	    return "orderPage/normalOrderPage";
//	}
//
//	@GetMapping("/normalOrderPage2")
//	public String normalOrderPage2(@RequestParam("sellingOrderNo") int sellingOrderNo,
//								   @RequestParam("productName") String productName,
//								   @RequestParam("productNameKr") String productNameKr,
//								   @RequestParam("") Model model
//													)







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
	public String buyBid(@RequestParam("productOptionSize") String productOptionSize,
						 Model model) {
//		log.info("구매 입찰로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("구매 입찰로 넘어왔음: productOptionSize={}", productOptionSize);

		// sellingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회
		ProductDTO findProductOptionSize = listService.findProductOptionSize(productOptionSize);



		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productDTO", findProductOptionSize);
//		model.addAttribute("sellingOrderNo", sellingOrderNo);
//		model.addAttribute("sellingOrderPrice", sellingOrderPrice); //여 주석을 풀면 에러떠
		model.addAttribute("productCode", findProductOptionSize.getProductCode());
		model.addAttribute("productName", findProductOptionSize.getProductName());
		model.addAttribute("productNameKr", findProductOptionSize.getProductNameKr());
		model.addAttribute("productOptionSize", findProductOptionSize.getProductOption().get(0).getProductOptionSize());


		return "bid/buyBid";
		
	}
	
	
	@GetMapping("/sellBid")
	public String sellBid(){
		return "bid/sellBid";
		
	}


}
