package com.greedy.thunderbolts.model.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.config.SecurityConfig;
import com.greedy.thunderbolts.model.dao.MypageMapper;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
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
	public void updateInfo(AttachmentFileDTO attachment) {
		log.info("[updateInfo] : {} " + attachment);
		mypageMapper.insertProfile(attachment);
	}

}
