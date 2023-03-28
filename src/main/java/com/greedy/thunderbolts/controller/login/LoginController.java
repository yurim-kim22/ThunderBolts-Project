package com.greedy.thunderbolts.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.service.login.MemberService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;
	private final MemberService memberService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public LoginController (MessageSourceAccessor messageSourceAccessor, HttpSession httpSession, MemberService memberService, PasswordEncoder passwordEncoder) {
		this.messageSourceAccessor =  messageSourceAccessor;
		this.httpSession = httpSession;
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/main")
	public String loginMain() {
		return "login/loginMain";
	}
	
	@PostMapping("/false")
	public String loginFalse(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
		
		return "redirect:/login/main";
		
	}
	
	@GetMapping("/regist")
	public String loginRegist() {
		return "login/loginRegist";
	}
	
	/*
	 * 아이디 중복 체크 - 비동기 통신
	 *
	 * HttpEntity : HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를
	 * 포함하는 클래스 이를 상속받아 구현한 클래스가 RequestEntity, ResponseEntity 클래스 ResponseEntity :
	 * 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스 (HttpStatus, HttpHeaders, HttpBody를 포함)
	 *
	 * 규약에 맞는 HTTP Response를 반환하는데 ResponseEntity의 사용 목적이 있다.
	 */
	@PostMapping("/idDupCheck")
	public ResponseEntity<String> checkDuplication(@RequestBody MembersDTO member) {
		String result = "사용 가능한 아이디입니다.";
		log.info("[MemberController] Request Check ID : {}", member.getMembersId());
		
		if (memberService.selectMemberById(member.getMembersId())) {
			log.info("[MemberController] Already Exist");
			result = "중복 된 아이디가 존재합니다.";
		}
		// ResponseEntity의 body를 String으로 선언하여 result라는 String을 반환한다.
		// Ok라는 상태코드 (200)을 반환 한다 (result)와 함께 - alert하기 위해서 반환 js파일쪽으로
		return ResponseEntity.ok(result);
	}

	/* 회원 가입 */
	@PostMapping("/regist")
	public String registMember(@ModelAttribute MembersDTO member, RedirectAttributes rttr) throws Exception {

		member.setMembersPwd(passwordEncoder.encode(member.getMembersPwd()));

		log.info("[MemberController] registMember request Member : " + member);
		
		String message = memberService.registMember(member);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage(message));
		
		String redirectUrl="redirect:/";
		
		if(message != "member.regist") {
			redirectUrl = "redirect:/login/regist";
		}
		log.info("[Controller] message : {}" , redirectUrl);
		return redirectUrl;
	}
	
	/* 아이디 찾기 */
	@GetMapping("/searchId")
	public String searchIdPage() {
		return "login/searchId";
	}
	
	/* 아이디 찾기 진행 */
	@PostMapping("/searchId")
	public ResponseEntity<String> searchId(@RequestBody MembersDTO membersTel) {
		
		log.info("[MemberController] Request Check TEL: {}", membersTel);
		
		String memberTel = membersTel.getMembersTel();
		String result = memberService.selectIdByTel(memberTel);
		
		if(result == null) {
			log.info("[MemberController] Already Exist");
			 result = "일치하는 회원정보가 없습니다.";
		}
		
		
		 
		// ResponseEntity의 body를 String으로 선언하여 result라는 String을 반환한다.
		// Ok라는 상태코드 (200)을 반환 한다 (result)와 함께 - alert하기 위해서 반환 js파일쪽으로
		return ResponseEntity.ok(result);
		
	}
	
	
	
	/* 비밀번호 찾기 페이지 */
	@GetMapping("/searchPw")
	public String serachPwPage() {
		return "login/searchPw";
	}
	
	/* 비밀번호 찾기 진행 */
	@PostMapping("/searchPw")
	public String serachPw(MembersDTO member,RedirectAttributes rttr) {
		log.info("[searchPw Controller request] : {}",member);
		
		if (memberService.findMemberbyIdTel(member)) {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.searchPw"));
		} else {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.searchPwerror"));
		}
		 
		return "redirect:/login/main";
	}
	
	 	
}