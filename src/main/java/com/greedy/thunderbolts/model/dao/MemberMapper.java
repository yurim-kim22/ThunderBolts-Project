package com.greedy.thunderbolts.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.MembersDTO;

@Mapper
public interface MemberMapper {
	
	MembersDTO findByMemberId(String memberId);

}
