package com.greedy.thunderbolts.model.service.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.thunderbolts.common.paging.Pagenation;
import com.greedy.thunderbolts.common.paging.SelectCriteria;
import com.greedy.thunderbolts.config.SecurityConfig;
import com.greedy.thunderbolts.model.dao.MypageMapper;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.DetailDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.MembersIdDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.WishDTO;

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

	// 구매내역 조회
	@Override
	public BuyListDTO selectBuyList(String memberId) {
		return mypageMapper.selectBuyList(memberId);
	}

	// 판매내역 조회
	@Override
	public SellListDTO selectSellList(String memberId) {
		return mypageMapper.selectSellList(memberId);
	}

	// 내정보관리 - 조회
	@Override
	public MembersDTO selectInfo(String memberId) {
		return mypageMapper.selectInfo(memberId);
	}

	// 내정보관리 프로필 사진 인서트
	@Override
	public int insertProfile(AttachmentFileDTO attachment) {
		return mypageMapper.insertProfile(attachment);
	}

	// 내정보관리 이름 비밀번호 수정
	@Override
	public int modifyInfo(MembersDTO members, String memberId) {
		// TODO Auto-generated method stub
		return mypageMapper.modifyInfo(members, memberId);
	}

	// 주소록 추가
	@Override
	public int insertAddress(AddressDTO address, int memberNo) {
		return mypageMapper.insertAddress(address, memberNo);
	}

	// 주소록 조회
	/*
	 * @Override public List<AddressDTO> selectAddress(int memberNo) { return
	 * mypageMapper.selectAddress(memberNo); }
	 */
	// 주소록 페이징
	@Override
	public Map<String, Object> selectAddressList(int memberNo, int page) {
		// 1. 전체 게시글 수 확인
		int totalCount = mypageMapper.selectTotalCount(memberNo);

		// 한페이지에 보여줄 게시물의 수
		int limit = 7;
		// 한번에 보여질 페이징 버튼의 수
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);

		// 3. 요청 페이지에 맞는 게시글을 조회해온다
		List<AddressDTO> addressList = mypageMapper.selectAddress(selectCriteria, memberNo);
		log.info("[addressList] addressList : {}", addressList);

		Map<String, Object> selectAddressList = new HashMap<>();
		selectAddressList.put("paging", selectCriteria);
		selectAddressList.put("addressList", addressList);

		return selectAddressList;
	}

	// 계좌 조회
	@Override
	public MembersAccountsDTO selectAccounts(int memberNo) {
		return mypageMapper.selectAccounts(memberNo);
	}

	// 계좌 추가
	@Override
	public int inserAccounts(MembersAccountsDTO account, int memberNo) {
		return mypageMapper.inserAccounts(account, memberNo);
	}

	// 계좌 수정
	@Override
	public int modifyAccounts(MembersAccountsDTO account, int memberNo) {
		return mypageMapper.modifyAccounts(account, memberNo);
	}

	// 구매내역목록 페이징
	@Override
	public Map<String, Object> buyingList(int memberNo, int page) {
		// 1. 전체 게시글 수 확인
		int totalCount = mypageMapper.manyBuyingCount(memberNo);

		// 한페이지에 보여줄 게시물의 수
		int limit = 4;
		// 한번에 보여질 페이징 버튼의 수
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);

		// 3. 요청 페이지에 맞는 게시글을 조회해온다
		List<BuyListDTO> buyingList = mypageMapper.selectManyBuying(selectCriteria, memberNo);
		log.info("[buyingList] buyingList : {}", buyingList);

		Map<String, Object> selectbuyingList = new HashMap<>();
		selectbuyingList.put("paging", selectCriteria);
		selectbuyingList.put("buyingList", buyingList);

		return selectbuyingList;
	}

	// 판매내역목록 페이징
	@Override
	public Map<String, Object> sellingList(int memberNo, int page) {
		// 1. 전체 게시글 수 확인
		int totalCount = mypageMapper.manySellingCount(memberNo);

		// 한페이지에 보여줄 게시물의 수
		int limit = 4;
		// 한번에 보여질 페이징 버튼의 수
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);

		// 3. 요청 페이지에 맞는 게시글을 조회해온다
		List<SellListDTO> sellingList = mypageMapper.selectManySelling(selectCriteria, memberNo);
		log.info("[sellingList] sellingList : {}", sellingList);

		Map<String, Object> selectSellingList = new HashMap<>();
		selectSellingList.put("paging", selectCriteria);
		selectSellingList.put("sellingList", sellingList);

		return selectSellingList;
	}

	// 관심상품목록 페이징
	@Override
	public Map<String, Object> wishList(int memberNo, int page) {
		
		// 1. 전체 게시글 수 확인
		int totalCount = mypageMapper.wishListCount(memberNo);

		// 한페이지에 보여줄 게시물의 수
		int limit = 4;
		// 한번에 보여질 페이징 버튼의 수
		int buttonAmount = 3;

		/* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);

		// 3. 요청 페이지에 맞는 게시글을 조회해온다
		List<WishDTO> wishList = mypageMapper.selectWishList(selectCriteria, memberNo);
		log.info("[servicefile] wishList : {}", wishList);

		Map<String, Object> selectWishList = new HashMap<>();
		selectWishList.put("paging", selectCriteria);
		selectWishList.put("wishList", wishList);

		return selectWishList;
		
	}
	
	//구매상세 
	@Override
	public DetailDTO detailBuy(Long no) {
		return mypageMapper.detailBuy(no);
	}
	
	//판매상세
	@Override
	public DetailDTO detailSell(Long no) {
		// TODO Auto-generated method stub
		return mypageMapper.detailSell(no);
	}

}