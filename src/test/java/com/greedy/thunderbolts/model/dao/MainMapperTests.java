package com.greedy.thunderbolts.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.ProductDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = { Application.class })
public class MainMapperTests {

	@Autowired
	private MainMapper mapper;


	@Test
	public void 매퍼_테스트() {
		
		assertNotNull(mapper);
	}

	@Test
	public void findNewProduct() {
		List<ProductDTO> newProductList = mapper.findNewProduct();
		
		for (ProductDTO a : newProductList) {
		log.info("[Test MainMapper] findNewProduct newProductList : {}", 
		
			a.getProductOption().get(0).getSellingOrders().get(0).getSellingOrderPrice());};
}
	
	
}
