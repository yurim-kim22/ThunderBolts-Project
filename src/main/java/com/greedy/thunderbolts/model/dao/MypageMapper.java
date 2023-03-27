package com.greedy.thunderbolts.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
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
	int modifyInfo(@Param("members")MembersDTO members , @Param("memberId") String memberId);
	
	
	
	//주소록 인서트
	int insertAddress(@Param("address")AddressDTO address , @Param("memberNo") int memberNo);
	//주소록 조회
	List<AddressDTO> selectAddress(int memberNo);
	//계좌 조회
	MembersAccountsDTO selectAccounts(int memberNo);
	//계좌 인서트
	int inserAccounts(@Param("account")MembersAccountsDTO account , @Param("memberNo") int memberNo);
	//계좌 수정
	int modifyAccounts(@Param("account")MembersAccountsDTO account , @Param("memberNo") int memberNo);
	
}
