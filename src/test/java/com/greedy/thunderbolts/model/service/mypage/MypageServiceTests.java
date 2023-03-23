package com.greedy.thunderbolts.model.service.mypage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

@SpringBootTest
@ContextConfiguration(classes = {Application.class} )
public class MypageServiceTests {
	
	@Autowired
	private MypageService mypageService;
	
	@Test
	public void 마이페이지_서비스_메인_판매내역_테스트() {
		
		BuyListDTO buyList = mypageService.selectBuyList();
		
		assertNotNull(buyList);
		System.out.println(buyList);
	}
	
	@Test
	public void 마이페이지_서비스_메인_구매내역_테스트() {
		
		SellListDTO sellList = mypageService.selectSellList();
		
		assertNotNull(sellList);
		System.out.println(sellList);
	}
}
