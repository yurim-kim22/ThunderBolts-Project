package com.greedy.thunderbolts.controller.buselllist;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.thunderbolts.model.dto.BuyingOrdersDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.OrdersDTO;
import com.greedy.thunderbolts.model.dto.PaymentDTO;
import com.greedy.thunderbolts.model.dto.ProductDTO;
import com.greedy.thunderbolts.model.dto.ProductOptionDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.service.ListService;
import com.greedy.thunderbolts.model.service.orderService;
import com.siot.IamportRestClient.IamportClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orderPage")
public class OrderController {

	private ListService listService;
	private IamportClient api;
	private orderService orderService;
	

	private final MessageSourceAccessor messageSourceAccessor;

	public OrderController(ListService listService, MessageSourceAccessor messageSourceAccessor) {

		this.listService = listService;
		this.messageSourceAccessor = messageSourceAccessor;
		
		this.api = new IamportClient("1560407313735881","0j4FF5Xmm6McTeYcczUAJbjLfqyUFUhcePBrjosz61SyKDz5ZDdXnz2oyJFVjuLlk42HDlxmiQnDaUo1");
//		this.orderService = orderService;
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
			@AuthenticationPrincipal MembersDTO members, AddressDTO address, ProductDTO productDTO, Model model,
			@RequestParam("accountBank") String accountBank,MembersAccountsDTO membersAccount) {
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
		model.addAttribute("accountBank",accountBank);
		model.addAttribute("membersAccount",membersAccount);
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
	@PostMapping("/orderComplete")
	public String Complete(ProductDTO productDTO, Model model) {
		log.info("productDTO: productDTO={}", productDTO);
		
		return "orderPage/orderComplete";
	}
	
	@PostMapping("/orderComplete2")
	public String Complete2(ProductDTO productDTO, Model model) {
		log.info("productDTO: productDTO={}", productDTO);
		
		return "orderPage/orderComplete2";
	}
	
	//위에 아임포트 정의함
	
	@ResponseBody
	@PostMapping(value = "/verifyImport/{imgUid}")
	//ResponseEntity 리턴 되는값 지정 가능
	public ResponseEntity<String> verifyIamport(
			@AuthenticationPrincipal MembersDTO members,
			@RequestParam(value = "membersNo") int memberNo,
			@RequestParam(value = "sellingOrderNo") int sellingOrderNo,
			 OrdersDTO ordersDTO,
			Model model,Local local) {
		
		//멤버 넘버로 멤버 정보와, 주소조회하기
		//왜 안될까....
		MembersDTO memberOrder = listService.memberOrder(memberNo);
		
		//1.재정의 하면 안된다. 2.int값이라서도 안됨
//		OrdersDTO ordersDTO = listService.insertBuy(ordersDTO);
		
		//리턴이있는데 리턴을 안받는 형식
		listService.insertBuy(ordersDTO);
		
		//1. 정의를 해줘도 된다 RequestBody
		
		//2.PaymentDTO payment = new PaymentDTO(); 없던 친구라서 생성을 해준 것.
		PaymentDTO payment = new PaymentDTO();
		
		//insert는 값이 필요한 경우에는 세팅을 하는데 없으면
		//값이 넘어갈 게 없으면 파라미터를 안 받아도 된다
		listService.buyInsertPay(payment);
		
		return new ResponseEntity<String>(HttpStatus.OK);
//		return api.paymentByImpUid();
		

	}

}