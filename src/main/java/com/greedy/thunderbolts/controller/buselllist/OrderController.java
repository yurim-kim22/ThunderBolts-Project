package com.greedy.thunderbolts.controller.buselllist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/orderPage")
public class OrderController {
	
	private ListService listService;

	private final MessageSourceAccessor messageSourceAccessor;
	
	public OrderController(ListService listService, MessageSourceAccessor messageSourceAccessor) {

		this.listService= listService;
		this.messageSourceAccessor = messageSourceAccessor;
	}


	
	@PostMapping("/normalOrderPage")
	public String normalOrderPage(@RequestParam("sellingOrderNo") int sellingOrderNo,
								  @RequestParam("sellingOrderPrice") int sellingOrderPrice,
								 Model model) {

		log.info("결제요청으로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("결제요청으로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);

		//프로덕트 셀링 넘버 받기
		ProductDTO findSellingProduct = listService.findSellingProduct(sellingOrderNo);

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

//	//주소록 조회
//	@GetMapping("/normalOrderPageAdress")
//	public String addressMain(@AuthenticationPrincipal MembersDTO members, AddressDTO address, Model model) {
//
//		int memberNo = members.getMembersNo();
//
//		List<AddressDTO> selectAddress = ListService.selectAddress(memberNo);
//		log.info("[selectAddress] selectAddress : {}", selectAddress);
//
//		model.addAttribute("selectAddress", selectAddress);
//
//		return "orderPage/normalOrderPage";
//	}

	//주소록 추가
//	@PostMapping("/address")
//	public String address(@AuthenticationPrincipal MembersDTO members, AddressDTO address, Model model, RedirectAttributes rttr){
//
//		int memberNo = members.getMembersNo();
//		log.info("[memberNo] : {}", memberNo);
//		log.info("[address] : {}", address);
//
//		int insertAddress = ListService.insertAddress(address, memberNo);
//
//		log.info("[insertAddress] : {}", insertAddress);
//
//		if(insertAddress == 0) {
//			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("address.registerror"));
//		}else {
//			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("address.regist"));
//		}
//
//		return "redirect:/mypage/address";
//	}

	@PostMapping("/buyBidOrderPage")
	public String buyBidOrderPage(@RequestParam("buyingOrderPrice") int buyingOrderPrice,

								  ProductDTO productDTO,
								  Model model) {

		log.info("입찰 동의서로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);

		log.info("productDTO: productDTO={}", productDTO);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//	    model.addAttribute("productCode", productDTO.getProductCode());
//	    model.addAttribute("productName", productDTO.getProductName());
		model.addAttribute("buyingOrderPrice", buyingOrderPrice);

		return "orderPage/buyBidOrderPage";
	}


	//주소록


	//주소록 추가



	
	@PostMapping("/succedOrderComplite")
	public String Complite() {
		//log.info("완: buyingOrderPrice={}", buyingOrderPrice);
		//log.info("입찰 구매로 넘어왔음: buyingOrderDeadlineDate={}", buyingOrderDeadlineDate);
		return "agreeAtc/orderCompliete";
	}
	
	
	

}