package com.greedy.thunderbolts.model.service.mypage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.service.login.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {Application.class} )
public class LoginServiceTests {
	
	@Autowired
	private MemberService memberService;
	private String membersTel;
	
	@Test
	public void 서비스_테스트() {
		assertNotNull(memberService);
		assertNotNull(membersTel);
	}
	
	@Test
	public void 마이페이지_서비스_메인_판매내역_테스트() {
		
		membersTel= "01000000000";
		
		String membersId = memberService.selectIdByTel(membersTel);
		
		assertNotNull(membersId);
		log.info("[Test service] selectIdByTel membersId : {}", membersId);
	}
	

}
