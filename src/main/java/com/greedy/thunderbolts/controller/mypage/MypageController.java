package com.greedy.thunderbolts.controller.mypage;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.MembersIdDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;
import com.greedy.thunderbolts.model.service.mypage.MypageService;
import com.greedy.thunderbolts.model.service.oauth.SessionUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private MypageService mypageService;
	private final HttpSession httpSession;
	
	@Autowired
	public MypageController(MypageService mypageService, HttpSession httpSession) {
		this.mypageService = mypageService;
		this.httpSession = httpSession;
	}
	
	//마이페이지 메인
	@GetMapping
	public String mypageMain(Model model) {
	    String memberId = ((SessionUser) httpSession.getAttribute("user")).getEmail();
	    
	    
	    log.info("[Controller] : {}", memberId );
	    
	    BuyListDTO buyList = mypageService.selectBuyList(memberId);
	    SellListDTO sellList = mypageService.selectSellList(memberId);
	    MembersIdDTO selectId = mypageService.selectId(memberId);

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    String formattedBuyDate = dateFormat.format(buyList.getOrder().getOrdersDate());
	    String formattedSellDate = dateFormat.format(sellList.getOrder().getOrdersDate());

	    model.addAttribute("buyList", buyList);
	    model.addAttribute("sellList", sellList);
	    model.addAttribute("selectId", selectId);
	    model.addAttribute("buyDate", formattedBuyDate);
	    model.addAttribute("sellDate", formattedSellDate);

	    log.info("buyList", buyList);
	    log.info("sellList", sellList);

	    return "mypage/mypageMain";
	}
	
	//마이페이지 관심상품
	@GetMapping("/wish")
	public String wish(){
		
		return "mypage/wish";
	}
	
	//마이페이지 관심상품
	@GetMapping("/info")
	public String info(){
			
		return "mypage/information";
	}
	

}
