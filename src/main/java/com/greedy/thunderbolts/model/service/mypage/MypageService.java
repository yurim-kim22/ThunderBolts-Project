package com.greedy.thunderbolts.model.service.mypage;

import org.apache.ibatis.annotations.Param;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.MembersIdDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

public interface MypageService {
	//메인 구매내역 조회
	BuyListDTO selectBuyList(String memberId);
	//메인 판매내역 조회
	SellListDTO selectSellList(String memberId);
	//내정보관리 조회
	MembersDTO selectInfo(String memberId);
	//내정보관리 프로필 사진 인서트
	void updateInfo(AttachmentFileDTO attachment);
	//주소록 추가
	int insertAddress(@Param("address")AddressDTO address , @Param("memberNo") int memberNo);
	
}
