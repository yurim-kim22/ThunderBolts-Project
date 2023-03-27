package com.greedy.thunderbolts.model.service.login;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final RandomPw randomPw;
	private final PasswordEncoder passwordEncoder;

	public MemberService(MemberMapper mapper, RandomPw randomPw, PasswordEncoder passwordEncoder) {
		this.mapper = mapper;
		this.randomPw = randomPw;
		this.passwordEncoder = passwordEncoder;
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

	public boolean findMemberbyIdTel(MembersDTO member) {
		log.info("[searchPw service request] : {}",member);
		
		MembersDTO members = mapper.findMemberbyIdTel(member);
		
		log.info("[searchPw sevice response] : {}",member);

		log.info("[searchPw sevice request pw] : {}",member);
		if(members != null) {
		String newPass = randomPw.randowPws();
		
		members.setMembersPwd(passwordEncoder.encode(newPass));
		int result = mapper.updatePwd(members);
		
		} else {
			
		}
		
		
		return members != null ? true : false;	
		
	}
	

	
	
	
	
	
	
	
	
	
}
