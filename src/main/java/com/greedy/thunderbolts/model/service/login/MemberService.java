package com.greedy.thunderbolts.model.service.login;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.controller.login.LoginController;
import com.greedy.thunderbolts.model.dao.MemberMapper;
import com.greedy.thunderbolts.model.dto.MembersDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberService {

	private final MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public boolean selectMemberById(String membersId) {

		String result = mapper.selectMembersById(membersId);

		return result != null ? true : false;
	}

	public String registMember(MembersDTO member) {
		
		log.info("[service] : {}" , member);
		
		int result1 = mapper.insertMembers(member); 
		int result2 = mapper.insertMembersRole();
		String message = "";
		
		log.info("[Service] result1 : {}" , result1);
		log.info("[Service] result2 : {}" , result2);
		
		if((result1 > 0 && result2 > 0 )) {
			message = "member.regist";
		} else {
			message = "member.registerror";
		}
		log.info("[Service] message : {}" , message);
		return message;
	}

//	public String selectIDbyTel() {
//		
//	}
	

	
	
	
	
	
	
	
	
	
}
