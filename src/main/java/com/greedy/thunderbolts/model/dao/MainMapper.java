package com.greedy.thunderbolts.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.ProductDTO;

@Mapper
public interface MainMapper {

	List<ProductDTO> findNewProduct();

	List<ProductDTO> findHotroduct();

	List<ProductDTO> bestHotroduct();

}
