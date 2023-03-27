package com.greedy.thunderbolts.model.service.login;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		String membersId = member.getMembersId();
		String result = mapper.selectMembersById(membersId);
		String message = "";
		
		if(result == null) {
		int result1 = mapper.insertMembers(member); 
		int result2 = mapper.insertMembersRole();
		
		
		log.info("[Service] result1 : {}" , result1);
		log.info("[Service] result2 : {}" , result2);
		
		if((result1 > 0 && result2 > 0 )) {
			message = "member.regist";
		} else {
			message = "member.registerror";
		}
		log.info("[Service] message : {}" , message);
		} else {message = "member.registerror";}
		return message;
	}

	public String selectIdByTel(String memberTel) {
		
		log.info("[Service] selectIdByTel MembersTel : {}", memberTel);
		
		String result  = mapper.selectIdByTel(memberTel);
		
		log.info("[Service] selectIdByTel membersId : {}", result);
		
		
		return result;
		
	}
	

	
	
	
	
	
	
	
	
	
}
