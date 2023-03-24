package com.greedy.thunderbolts.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {Application.class} )
public class MypageMapperTests {

	@Autowired
	private MypageMapper mypageMapper;
	
	@Test
	public void 매퍼_테스트() {
		assertNotNull(mypageMapper);
	}
	
	@Test
	public void 메인_구매내역_디비_조회_테스트() {
		
		String memberId = "hy@greedy.com"; // memberId 값을 설정
		
		BuyListDTO buyList = mypageMapper.selectBuyList(memberId);
		
		assertNotNull(buyList);
		log.info("구매 내역 : {} ", buyList);
	}
	
	@Test
	public void 메인_판매내역_디비_조회_테스트() {
		
		String memberId = "hy@greedy.com"; // memberId 값을 설정
		
		SellListDTO sellList = mypageMapper.selectSellList(memberId);
		
		assertNotNull(sellList);
		log.info("판매 내역 : {} ", sellList);
	}
	

}
