package com.greedy.thunderbolts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.greedy.thunderbolts.model.service.login.AuthenticationService;
import com.greedy.thunderbolts.model.service.oauth.Role;
import com.greedy.thunderbolts.model.service.oauth.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final AuthenticationService authenticationService;
	private final UserService userService;
	
	public SecurityConfig(AuthenticationService authenticationService, UserService userService) {
		this.authenticationService = authenticationService;
		this.userService = userService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		.and()
        .authorizeRequests()
        .antMatchers("/mypage/**", "/list/**", "/member/update", "/member/delete").hasRole("MEMBER")
        .antMatchers("/mypage/**", "/list/**", "/member/update", "/member/delete").hasRole(Role.MEMBER.name())
        .antMatchers("/mypage/**", "/list/**", "/member/update", "/member/delete").hasRole("ADMIN")
        // 관리자만 사용 가능한 기능은 현재는 없음
        .anyRequest().permitAll()
        .and()
            .formLogin()
            .loginPage("/login/main")             
            .defaultSuccessUrl("/")  
            .failureForwardUrl("/login/false")
            .usernameParameter("membersId")			// 아이디 파라미터명 설정 기본값 username에서 변경
            .passwordParameter("membersPwd")			// 패스워드 파라미터명 설정 기본값 password에서 변경    
        .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/login/logout"))
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .logoutSuccessUrl("/")
        .and()
            .oauth2Login()
            .userInfoEndpoint()
            .userService(userService);
        // 따라서 인가 오류 처리는 생략하였음
		log.info("[userService] : {} " + userService);
        return	http.build();
	}
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				   .userDetailsService(authenticationService)
				   .passwordEncoder(passwordEncoder())
				   .and()
				   .build();
	}


}


