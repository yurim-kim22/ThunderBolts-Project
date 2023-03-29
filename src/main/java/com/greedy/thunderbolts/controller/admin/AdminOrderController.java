package com.greedy.thunderbolts.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.thunderbolts.model.dto.AdminOrderDTO;
import com.greedy.thunderbolts.model.service.admin.AdminOrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminOrderController {

	private final AdminOrderService orderService;
	private final MessageSourceAccessor messageSourceAccessor;

	public AdminOrderController(AdminOrderService orderService, MessageSourceAccessor messageSourceAccessor) {
		this.orderService = orderService;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	/* 메인페이지 옵션에 따른 검색 */
	@GetMapping("/orderMainPage")
	public String OrderList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String searchCondition, @RequestParam(required = false) String searchValue,
			Model model) {

		log.info("[AdminOrderController] page : {} ", page);
		// if(searchCondition != null || searchValue != null) {
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		log.info("[AdminOrderController] searchMap : {}", searchMap);

		Map<String, Object> OrderListAndPaging = orderService.selectOrderList(searchMap, page);
		model.addAttribute("paging", OrderListAndPaging.get("paging"));
		model.addAttribute("orderList", OrderListAndPaging.get("orderList"));
		// }

		return "admin/order/orderMain";

	}

	@GetMapping("/OrderbuyingPage")
	public String BuyingList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String searchCondition, @RequestParam(required = false) String searchValue,
			Model model) {

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		Map<String, Object> OrderListAndPaging = orderService.selectOrderList(searchMap, page);
		model.addAttribute("paging", OrderListAndPaging.get("paging"));
		model.addAttribute("orderList", OrderListAndPaging.get("orderList"));

		return "admin/orderBuying";

	}

	@GetMapping("/OrderSellingPage")
	public String SellingList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String searchCondition, @RequestParam(required = false) String searchValue,
			Model model) {

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		Map<String, Object> OrderListAndPaging = orderService.selectOrderList(searchMap, page);
		model.addAttribute("paging", OrderListAndPaging.get("paging"));
		model.addAttribute("orderList", OrderListAndPaging.get("orderList"));

		return "admin/orderBuying";

	}

}
