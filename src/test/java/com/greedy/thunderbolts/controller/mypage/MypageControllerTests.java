package com.greedy.thunderbolts.controller.mypage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.greedy.thunderbolts.Application;

@SpringBootTest
@ContextConfiguration(classes = {Application.class} )
public class MypageControllerTests {
	
	@Autowired
	private MypageController mypageController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mypageController).build();
	}
	
	@Test
	public void 컨트롤러_테스트() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/mypage"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.forwardedUrl("mypage/mypageMain"))
		.andDo(MockMvcResultHandlers.print());
		/*
		 * 
		 * .andExpect(MockMvcResultMatchers.forwardedUrl("/mypage/mypageMain"))
		 * .andDo(MockMvcResultHandlers.print());
		 */
	}
}
