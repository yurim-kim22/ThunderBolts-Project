package com.greedy.thunderbolts.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

@Mapper
public interface MypageMapper {
	//메인 구매내역 조회
	BuyListDTO selectBuyList(String memberId);
	//메인 판매내역 조회
	SellListDTO selectSellList(String memberId);
	//내정보관리 조회
	MembersDTO selectInfo(String memberId);
	//내정보관리 프로필 사진 인서트
	int insertProfile(AttachmentFileDTO attachment);
	//내정보관리 수정 이름 비밀번호
	int modifyInfo(MembersDTO member);
	//주소록 인서트
	int selectAddress();
	//주소록 조회
	
	
}
