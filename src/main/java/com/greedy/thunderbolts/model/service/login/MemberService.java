package com.greedy.thunderbolts.model.service.login;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
	private final MailSender mailSender;

	public MemberService(MemberMapper mapper, RandomPw randomPw, PasswordEncoder passwordEncoder, MailSender mailSender) {
		this.mapper = mapper;
		this.randomPw = randomPw;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
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

		
		if (members != null) {
			String newPass = randomPw.randowPws();
			log.info("[searchPw sevice request randomPw] : {}", randomPw);

			members.setMembersPwd(passwordEncoder.encode(newPass));
			int result = mapper.updatePwd(members);

			log.info("[searchPw sevice request members] : {}", members);
			log.info("[searchPw sevice request result] : {}", result);
			if (result > 0) {

				MembersDTO pwdEmail = new MembersDTO();
				pwdEmail.setMembersId(members.getMembersId());
				pwdEmail.setMembersPwd(newPass);

				mailSend(pwdEmail);
			} else { members = null;}

		}
		
		
		return members != null ? true : false;	
		
	}
	

	 public void mailSend(MembersDTO members) {
	     	String text = "안녕하세요. ThunderBolts 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 "
	                + members.getMembersPwd() + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요";
		 	
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(members.getMembersId());
	        message.setSubject("ThunderBolts 임시비밀번호 안내 이메일 입니다.");
	        message.setText(text);
	        message.setFrom("kbo0609@naver.com");
	        message.setReplyTo("kbo0609@naver.com");
	      
	        mailSender.send(message);
	    }
	
	
	
	
	
	
	
	
}
