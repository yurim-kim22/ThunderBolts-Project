package com.greedy.thunderbolts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


//@Configuration
//public class WebMvcConfigurer implements WebMvcConfigurer {
//	
//	/* WebMvcConfigurer : WebMvc와 관련 된 설정을 할 수 있는 메소드가 default 메소드로 선언 된 인터페이스 */
//
//	/* addResourceHandlers : 정적 리소스와 관련하여 static 경로는 기본으로 설정되어 있으므로 추가적인 정적 리소스 경로를 설정할 때 사용 
//	 * 정적인 리소스에 대한 경로를 추가 할수 있다. ( 기본적으로 resources/static폴더로 설정되어 있는걸 변경하여 
//	 * 그 위치가 정적인 리소스파일이 있다고 정의하는것이다.*/
//	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	
//		/* upload 경로를 추가하여 업로드 된 이미지를 정적 리소르로 요청할 수 있게 한다. */
//		
//		/*/upload/**에 요청이 오면, classpath(resources):/upload/로 변경해서 연결해라 (static 대신)*/
//		/*
//		 * registry.addResourceHandler("/upload/**")
//		 * .addResourceLocations("classpath:/upload/");
//		 */
//		
//		registry.addResourceHandler("/upload/**")
//			.addResourceLocations("classpath:/upload/");
//		}
//}