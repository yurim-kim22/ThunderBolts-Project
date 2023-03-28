package com.greedy.thunderbolts.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.ProductDTO;

@Mapper
public class MainMapper {

	public static List<ProductDTO> findProduct() {
		return null;
	}

}
