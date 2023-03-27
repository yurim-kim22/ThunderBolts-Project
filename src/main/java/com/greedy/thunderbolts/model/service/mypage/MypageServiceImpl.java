package com.greedy.thunderbolts.model.service.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.config.SecurityConfig;
import com.greedy.thunderbolts.model.dao.MypageMapper;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.MembersIdDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("mypageService")
@Transactional
public class MypageServiceImpl implements MypageService {
	
	private final MypageMapper mypageMapper;
	
	
	@Autowired
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}
	
	//구매내역 조회
	@Override
	public BuyListDTO selectBuyList(String memberId) {
		return mypageMapper.selectBuyList(memberId);
	}
	
	//판매내역 조회
	@Override
	public SellListDTO selectSellList(String memberId) {
		return mypageMapper.selectSellList(memberId);
	}
	
	//내정보관리 - 조회
	@Override
	public MembersDTO selectInfo(String memberId) {
		return mypageMapper.selectInfo(memberId);
	}
	
	

	//내정보관리 프로필 사진 인서트
	@Override
	public int insertProfile(AttachmentFileDTO attachment) {
		return mypageMapper.insertProfile(attachment);
	}
	//내정보관리 이름 비밀번호 수정
	@Override
	public int modifyInfo(MembersDTO members, String memberId) {
		// TODO Auto-generated method stub
		return mypageMapper.modifyInfo(members, memberId);
	}
	
	
	
	
	//주소록 추가
	@Override
	public int insertAddress(AddressDTO address, int memberNo) {
		return mypageMapper.insertAddress(address, memberNo);
	}
	//주소록 조회
	@Override
	public List<AddressDTO> selectAddress(int memberNo) {
		return mypageMapper.selectAddress(memberNo);
	}
	//계좌 조회
	@Override
	public MembersAccountsDTO selectAccounts(int memberNo) {
		return mypageMapper.selectAccounts(memberNo);
	}
	//계좌 추가
	@Override
	public int inserAccounts(MembersAccountsDTO account, int memberNo) {
		return mypageMapper.inserAccounts(account, memberNo);
	}
	//계좌 수정
	@Override
	public int modifyAccounts(MembersAccountsDTO account, int memberNo) {
		return mypageMapper.modifyAccounts(account, memberNo);
	}






}
