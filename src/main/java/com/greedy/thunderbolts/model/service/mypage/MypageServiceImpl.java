package com.greedy.thunderbolts.model.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.MypageMapper;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

@Service("mypageService")
public class MypageServiceImpl implements MypageService {
	
	private final MypageMapper mypageMapper;
	
	@Autowired
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}

	@Override
	public BuyListDTO selectBuyList() {
		return mypageMapper.selectBuyList();
	}

	@Override
	public SellListDTO selectSellList() {
		return mypageMapper.selectSellList();
	}



	

}
