package com.greedy.thunderbolts.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.thunderbolts.model.service.oauth.SessionUser;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	

    private final HttpSession httpSession;
	
	private final MessageSourceAccessor messageSourceAccessor;
	
	public LoginController (MessageSourceAccessor messageSourceAccessor, HttpSession httpSession) {
		this.messageSourceAccessor =  messageSourceAccessor;
		this.httpSession = httpSession;
	}
	
	
	@GetMapping("/Main")
	public String loginMain(Model model) {
		 	
	        SessionUser user = (SessionUser) httpSession.getAttribute("user");
	        log.info("[Controller] : {}", user );
	        if(user != null){
	            model.addAttribute("userName", user.getName());
	        }
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

	
}
