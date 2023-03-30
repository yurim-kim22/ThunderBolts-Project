package com.greedy.thunderbolts.model.service.mypage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.DetailDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

public interface MypageService {
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
	
	
	//주소록 추가
	int insertAddress(@Param("address")AddressDTO address , @Param("memberNo") int memberNo);
	//주소록 조회
	//List<AddressDTO> selectAddress(@Param("criteria")SelectCriteria selectCriteria, @Param("memberNo")int memberNo);
	//주소록 페이징
	Map<String, Object> selectAddressList(int memberNo, int page);
		
		
		
	//계좌 조회
	MembersAccountsDTO selectAccounts(int memberNo);
	//계좌 추가
	int inserAccounts(@Param("account")MembersAccountsDTO account , @Param("memberNo") int memberNo);
	//계좌 수정
	int modifyAccounts(@Param("account")MembersAccountsDTO account , @Param("memberNo") int memberNo);
	
	
	//구매내역목록 페이징
	Map<String, Object> buyingList(int memberNo, int page);
	//판매내역목록 페이징
	Map<String, Object> sellingList(int memberNo, int page);
	
	//관심상품목록 페이징
	Map<String, Object> wishList(int memberNo, int page);
	
	
	//구매상세내역
	DetailDTO detailBuy(Long no);
		
	//판매상세내역
	DetailDTO detailSell(Long no);
	
	//프로필 사진 띄우기
	AttachmentFileDTO selectprofile(String memberId);
	
	
}
