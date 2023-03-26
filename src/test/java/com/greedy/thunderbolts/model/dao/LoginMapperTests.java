package com.greedy.thunderbolts.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.MembersDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = { Application.class })
public class LoginMapperTests {

	@Autowired
	private MemberMapper mapper;
	private MembersDTO members;

	@Test
	public void 매퍼_테스트() {
		
		assertNotNull(mapper);
	}


	
	@Test
	public void 아이디_찾기_디비_조회_테스트() {
		
		members.setMembersTel("dddd");
		
		String memberTel = members.getMembersTel();
		
		log.info("[Test mapper] selectIdByTel memberTel : {}", memberTel);
		log.info("[Test mapper] selectIdByTel membersId : {}", members);
		
		MembersDTO membersId = mapper.selectIdByTel(members); 
		
		assertNotNull(memberTel);
		log.info("[Test mapper] selectIdByTel membersId : {}", memberTel);
		
	}

}
