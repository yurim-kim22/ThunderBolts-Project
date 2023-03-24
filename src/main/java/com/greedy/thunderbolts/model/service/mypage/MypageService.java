package com.greedy.thunderbolts.model.service.mypage;

import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

public interface MypageService {

	BuyListDTO selectBuyList(String memberId);
	
	SellListDTO selectSellList(String memberId);
	
	
}
