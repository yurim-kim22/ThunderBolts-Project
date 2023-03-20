package com.greedy.thunderbolts.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.BuyListDTO;

@Mapper
public interface MypageMapper {

	BuyListDTO selectBuyList();
}
