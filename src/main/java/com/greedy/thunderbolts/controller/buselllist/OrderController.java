package com.greedy.thunderbolts.controller.buselllist;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orderPage")
public class OrderController {

	private ListService listService;

	private final MessageSourceAccessor messageSourceAccessor;

	public OrderController(ListService listService, MessageSourceAccessor messageSourceAccessor) {

		this.listService = listService;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	@PostMapping("/normalOrderPage")
	public String normalOrderPage(@RequestParam("sellingOrderNo") int sellingOrderNo,
			@RequestParam("sellingOrderPrice") int sellingOrderPrice, Model model,
			@AuthenticationPrincipal MembersDTO members, AddressDTO address) {

		log.info("결제요청으로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("결제요청으로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);

		int memberNo = members.getMembersNo();

		// 주소조회
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		model.addAttribute("selectAddress", selectAddress);
		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

		// 프로덕트 셀링 넘버 받기
		ProductDTO findSellingProduct = listService.findSellingProduct(sellingOrderNo);

		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productDTO", findSellingProduct);
		model.addAttribute("sellingOrderNo", sellingOrderNo);
		model.addAttribute("sellingOrderPrice", sellingOrderPrice); // 여 주석을 풀면 에러떠
		model.addAttribute("productCode", findSellingProduct.getProductCode()); // 이
		model.addAttribute("productName", findSellingProduct.getProductName()); // 이거
		model.addAttribute("productNameKr", findSellingProduct.getProductNameKr());// 이
		model.addAttribute("productOptionSize", findSellingProduct.getProductOption().get(0).getProductOptionSize());

		model.addAttribute("selectAddress", selectAddress);
		model.addAttribute("members", members);

		return "orderPage/normalOrderPage";
	}

	@PostMapping("/normalSellPage")
	public String NormalSellPage(@RequestParam("buyingOrderCode") int buyingOrderCode,
			@RequestParam("buyingOrderPrice") int buyingOrderPrice, Model model,
			@AuthenticationPrincipal MembersDTO members) {

		log.info("결제요청으로 넘어왔음: buyingOrderCode={}", buyingOrderCode);
		log.info("결제요청으로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);

		int memberNo = members.getMembersNo();

		// 주소조회
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		ProductDTO findBuyingProduct = listService.findBuyingProduct(buyingOrderCode);

		model.addAttribute("selectAddress", selectAddress);
		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

		model.addAttribute("productDTO", findBuyingProduct);
		model.addAttribute("buyingOrderCode", buyingOrderCode);
		model.addAttribute("buyingOrderPrice", buyingOrderPrice); // 여 주석을 풀면 에러떠
		model.addAttribute("productCode", findBuyingProduct.getProductCode()); // 이
		model.addAttribute("productName", findBuyingProduct.getProductName()); // 이거
		model.addAttribute("productNameKr", findBuyingProduct.getProductNameKr());// 이
		model.addAttribute("productOptionSize", findBuyingProduct.getProductOption().get(0).getProductOptionSize());

		model.addAttribute("selectAddress", selectAddress);
		model.addAttribute("members", members);

		return "orderPage/normalSellPage";
	}

	// 수정하
	@PostMapping("/buyBidOrderPage")
	public String buyBidOrderPage(@RequestParam("buyingOrderPrice") int buyingOrderPrice,
			@AuthenticationPrincipal MembersDTO members, AddressDTO address, ProductDTO productDTO, Model model) {
		int memberNo = members.getMembersNo();
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		log.info("입찰 동의서로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);

		log.info("productDTO: productDTO={}", productDTO);
		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("selectAddress", selectAddress);
		model.addAttribute("selectAddress", selectAddress);
		model.addAttribute("members", members);

//	    model.addAttribute("productCode", productDTO.getProductCode());
//	    model.addAttribute("productName", productDTO.getProductName());
		model.addAttribute("buyingOrderPrice", buyingOrderPrice);

		return "orderPage/buyBidOrderPage";
	}

	@PostMapping("/sellBidOrderPage")
	public String sellBidOrderPage(@RequestParam("sellingOrderPrice") int sellingOrderPrice,
			@AuthenticationPrincipal MembersDTO members, AddressDTO address, ProductDTO productDTO, Model model) {
		int memberNo = members.getMembersNo();
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

		model.addAttribute("selectAddress", selectAddress);
		model.addAttribute("members", members);

		log.info("판매 입찰 동의서 완!!: sellingOrderPrice={}", sellingOrderPrice);

		log.info("productDTO: productDTO={}", productDTO);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		model.addAttribute("sellingOrderPrice", sellingOrderPrice);

		return "orderPage/sellBidOrderPage";

	}

	// 밸류안의 값이 다르기 떄문에 포스트가 충돌이 안난다.
	@PostMapping("/succedOrderComplete")
	public String Complite() {
		// log.info("완: buyingOrderPrice={}", buyingOrderPrice);
		// log.info("입찰 구매로 넘어왔음: buyingOrderDeadlineDate={}", buyingOrderDeadlineDate);
		return "agreeAtc/orderComplete";
	}

	@ResponseBody
	@PostMapping(value = "/verifyIamport/{impUid}")
	public ResponseEntity<String> verifyIamport(@AuthenticationPrincipal MembersDTO members,
			@RequestParam(value = "membersNo") String memberNo,
			@RequestParam(value = "sellingOrderNo") int sellingOrderNo,
			@RequestParam(value = "addressesNo") int addressesNo) {
		return ResponseEntity.ok("success");

	}

}