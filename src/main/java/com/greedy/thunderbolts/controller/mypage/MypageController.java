package com.greedy.thunderbolts.controller.mypage;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;
import com.greedy.thunderbolts.model.service.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	//마이페이지 메인
	@GetMapping
	public String mypageMain(Model model){
		
		BuyListDTO buyList = mypageService.selectBuyList();
		SellListDTO sellList = mypageService.selectSellList();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    String formattedBuyDate = dateFormat.format(buyList.getOrder().getOrdersDate());
	    String formattedSellDate = dateFormat.format(sellList.getOrder().getOrdersDate());
		
		model.addAttribute("buyList", buyList);
		model.addAttribute("sellList", sellList);
		model.addAttribute("buyDate", formattedBuyDate);
	    model.addAttribute("sellDate", formattedSellDate);
		
		log.info("buyList", buyList);
		log.info("sellList", sellList);
		
		return "mypage/mypageMain";
	}
	
	

}
