package com.greedy.thunderbolts.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String admin() {
		return "admin/delivery";
	}
	@GetMapping("/admin/decon")
	public String decon() {
		return"admin/decon";
	}
	@GetMapping("/admin/arrive")
	public String arrive() {
		return "admin/arrive";
		
	
	
	}
}

