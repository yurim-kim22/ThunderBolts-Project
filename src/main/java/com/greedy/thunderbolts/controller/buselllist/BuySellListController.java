package com.greedy.thunderbolts.controller.buselllist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.greedy.thunderbolts.model.dao.ListMapper;
import com.greedy.thunderbolts.model.dto.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/list")
public class BuySellListController {

	private ListService listService;

	public BuySellListController(ListService listService) {

		this.listService = listService;
	}


	@PostMapping("/normalBuy")
	public String PostnormalBuy(Model model) {
		List<ProductDTO> productList = listService.findProduct();
		List<ProductDTO> productSize = listService.findSizePrice();

		log.info("포스트 productList : {}", productList);
		log.info("productSize: {}", productSize);

		for (ProductDTO product : productList) {
			log.info(product.toString());
			for (ProductOptionDTO option : product.getProductOption()) {
				log.info(option.getSellingOrders().toString());
			}
		}

		// 뷰에 보이는거

		model.addAttribute("productList", productList);
		model.addAttribute("productSize", productSize);

		return "product/normalBuy";

	}

	// 셀오더 조회 포스트 2
	@PostMapping("/normalSell")
	public String PostnormalSell(Model model, ProductDTO productDTO, ProductOptionDTO productOptionDTO,
			BuyingOrdersDTO buyingOrdersDTO) {

		List<ProductDTO> selectBuyingOrder = listService.selectBuyingOrder();

		log.info("selectBuyingOrder: {}", selectBuyingOrder);
		log.info("구매 의향서 ProductDTO: {}", productDTO);
		model.addAttribute("selectBuyingOrder", selectBuyingOrder);
		model.addAttribute("productDTO", productDTO);
		model.addAttribute("buyingOrdersDTO", buyingOrdersDTO);

		return "product/normalSell";
	}

	// 판매 동의서
	@GetMapping("/normalSell2")
	public String GetNormalSell2(@RequestParam("buyingOrderCode") int buyingOrderCode,
			@RequestParam(value = "buyingOrderPrice", required = false) String buyingOrderPrice,
			@AuthenticationPrincipal MembersDTO members, AddressDTO address, Model model) {
		log.info("get판매 요청 어그리로 넘어왔음: buyingOrderCode={}", buyingOrderCode);
		log.info("get판매 요청 어그리로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);

		int memberNo = members.getMembersNo();

		// 주소조회
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		model.addAttribute("selectAddress", selectAddress);
		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

		// buyingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회

		ProductDTO findBuyingProduct = listService.findBuyingProduct(buyingOrderCode);

		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("buyingOrderCode", buyingOrderCode);
		model.addAttribute("buyingOrderPrice", buyingOrderPrice);
		model.addAttribute("productDTO", findBuyingProduct);
		model.addAttribute("productName", findBuyingProduct.getProductName());
		model.addAttribute("productNameKr", findBuyingProduct.getProductNameKr());
		model.addAttribute("productCode", findBuyingProduct.getProductCode());
		model.addAttribute("productOptionSize", findBuyingProduct.getProductOption().get(0).getProductOptionSize());
		model.addAttribute("selectAddress", selectAddress);

		return "agreeAtc/sellAgree";
	}

	// 입찰 판매 동의서
	@PostMapping("/normalSellAgree")
	public String PostNormalSell2(@RequestParam("sellingOrderPrice") int sellingOrderPrice,
			@RequestParam("sellingOrderDeadlineDate") Date sellingOrderDeadlineDate, ProductDTO productDTO,
			Model model) {
		log.info("post 입찰 어그리로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);
		log.info("post 입찰  어그리로 넘어왔음: sellingOrderDeadlineDate={}", sellingOrderDeadlineDate);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("sellingOrderPrice", sellingOrderPrice);
		model.addAttribute("sellingOrderDeadlineDate", date.format(sellingOrderDeadlineDate));

		return "agreeAtc/sellAgree2";
	}

	// 구매 동의서
	@GetMapping("/normalBuy2")
	public String normalBuy2(@RequestParam("sellingOrderNo") int sellingOrderNo,
			@RequestParam(value = "sellingOrderPrice", required = false) String sellingOrderPrice,
			@AuthenticationPrincipal MembersDTO members, AddressDTO address, Model model) {
		log.info("구매 요청 어그리로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("구매 요청 어그리로 넘어왔음: sellingOrderPrice={}", sellingOrderPrice);

		int memberNo = members.getMembersNo();

		// 주소조회
		List<AddressDTO> selectAddress = listService.selectAddress(memberNo);

		model.addAttribute("selectAddress", selectAddress);
		log.info("멤버주소 조회 selectAddress : {}", selectAddress);
		log.info("멤버 조회 members : {}", members);

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
		// 주소 조회
		model.addAttribute("selectAddress", selectAddress);

		return "agreeAtc/buyAgree";
	}

	// 입찰 동의서
	@PostMapping("/normalBuy4")
	public String buyBidOrderPage(@RequestParam("buyingOrderPrice") int buyingOrderPrice,
			@RequestParam("buyingOrderDeadlineDate") Date buyingOrderDeadlineDate, ProductDTO productDTO, Model model) {

		log.info("입찰 동의서로 넘어왔음: buyingOrderPrice={}", buyingOrderPrice);
		log.info("입찰 동의서로 넘어왔음: buyingOrderDeadlineDate={}", buyingOrderDeadlineDate);
		log.info("productDTO: productDTO={}", productDTO);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		model.addAttribute("buyingOrderPrice", buyingOrderPrice);
		model.addAttribute("buyingOrderDeadlineDate", sdf.format(buyingOrderDeadlineDate));

		return "agreeAtc/buyAgree2";
	}

	@GetMapping("/normalBuy3")
	public String normalBuy3(@RequestParam("productOptionSize") String productOptionSize, Model model) {
//		log.info("구매 입찰로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("이 !!!구매 입찰로 넘어왔음: productOptionSize={}", productOptionSize);

		// sellingOrderNo에 해당하는 제품 정보와 제품 옵션 정보 조회
		ProductDTO findProductOptionSize = listService.findProductOptionSize(productOptionSize);

		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productDTO", findProductOptionSize);
		model.addAttribute("productDTO", findProductOptionSize);
		model.addAttribute("productCode", findProductOptionSize.getProductCode());
		model.addAttribute("productName", findProductOptionSize.getProductName());
		model.addAttribute("productNameKr", findProductOptionSize.getProductNameKr());
		model.addAttribute("productOptionSize", findProductOptionSize.getProductOption().get(0).getProductOptionSize());

		return "bid/buyBid";
	}

	@GetMapping("/normal6")
	public String sellBid(@RequestParam("productOptionSize") String productOptionSize,

			Model model) {

		ProductDTO findProductOptionSizeSell = listService.findProductOptionSizeSell(productOptionSize);

//		log.info("구매 입찰로 넘어왔음: sellingOrderNo={}", sellingOrderNo);
		log.info("판매 입찰로 넘어왔음: productOptionSize={}", productOptionSize);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		// 뷰에서 사용할 모델 객체에 데이터 추가
		model.addAttribute("productName", findProductOptionSizeSell.getProductName());
		model.addAttribute("productNameKr", findProductOptionSizeSell.getProductNameKr());
		model.addAttribute("productCode", findProductOptionSizeSell.getProductCode());
		model.addAttribute("productOptionSize",
				findProductOptionSizeSell.getProductOption().get(0).getProductOptionSize());

		model.addAttribute("findProductOptionSizeSell", findProductOptionSizeSell);

		return "bid/sellBid";

	}

}