package com.greedy.thunderbolts.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = { Application.class })
public class MypageMapperTests {

	@Autowired
	private MypageMapper mypageMapper;

	@Test
	public void 매퍼_테스트() {
		assertNotNull(mypageMapper);
	}
	@Disabled
	@Test
	public void 메인_구매내역_디비_조회_테스트() {

		String memberId = "1111"; // memberId 값을 설정

		BuyListDTO buyList = mypageMapper.selectBuyList(memberId);

		assertNotNull(buyList);
		System.out.println(buyList);
	}
	@Disabled
	@Test
	public void 메인_판매내역_디비_조회_테스트() {

		String memberId = "1111"; // memberId 값을 설정

		SellListDTO sellList = mypageMapper.selectSellList(memberId);

		assertNotNull(sellList);
		System.out.println(sellList);
	}
	@Disabled
	@Test
	public void 내정보관리_조회_테스트() {

		String memberId = "1111"; // memberId 값을 설정

		MembersDTO selectInfo = mypageMapper.selectInfo(memberId);

		assertNotNull(selectInfo);
		System.out.println(selectInfo);
	}
	
	@Disabled
	@Test
	public void 내정보관리_프로필_사진_인서트() {
		AttachmentFileDTO attachment = new AttachmentFileDTO();
		attachment.setFileOriginalName("img");
		attachment.setFileDiv("profile");
		attachment.setFilePath("c");
		attachment.setFileDecoded("d");
		attachment.setFileThumbnailChecking("YES");

		int insertProfile = mypageMapper.insertProfile(attachment);

		System.out.println(insertProfile);
	}

	@Disabled
	@Test
	public void 주소록_인서트() {
		
		int memberNo = 2;
		
		AddressDTO address = new AddressDTO();
		address.setAddressesNo(1);
		address.setAddressesName("경기도");
		address.setAddressesPostNo("12222");
		address.setReceiverName("홍길동");
		address.setAddressesAdds("수원");
		
		log.info("address : {}", address);
		
		int insertAddress = mypageMapper.insertAddress(address, memberNo);

		log.info("insertAddress : {}", insertAddress);
	}
	@Disabled
	@Test
	public void 주소록_조회_테스트() {

		int memberNo = 2; 

		List<AddressDTO> selectAddress = mypageMapper.selectAddress(memberNo);

		assertNotNull(selectAddress);
		System.out.println(selectAddress);
	}
	@Disabled
	@Test
	public void 계좌_조회_테스트() {

		int memberNo = 2; 

		MembersAccountsDTO selectAccounts = mypageMapper.selectAccounts(memberNo);

		assertNotNull(selectAccounts);
		System.out.println(selectAccounts);
	}
	@Disabled
	@Test
	public void 계좌_인서트() {
		
		int memberNo = 2;
		
		MembersAccountsDTO account = new MembersAccountsDTO();
		account.setAccountNo("1");
		account.setAccountBank("국민은행");
		account.setAccountMaster("김예지");
		
		log.info("address : {}", account);
		
		int inserAccounts = mypageMapper.inserAccounts(account, memberNo);

		log.info("insertAddress : {}", inserAccounts);
	}

}
