package com.greedy.thunderbolts.model.service.mypage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.thunderbolts.Application;
import com.greedy.thunderbolts.model.dao.MypageMapperTests;
import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {Application.class} )
public class MypageServiceTests {
	
	@Autowired
	private MypageService mypageService;
	
	@Test
	public void 마이페이지_서비스_메인_판매내역_테스트() {
		
		String memberId = "1111";
		
		BuyListDTO buyList = mypageService.selectBuyList(memberId);
		
		assertNotNull(buyList);
		System.out.println(buyList);
	}
	
	@Test
	public void 마이페이지_서비스_메인_구매내역_테스트() {
		
		String memberId = "1111";
		
		SellListDTO sellList = mypageService.selectSellList(memberId);
		
		assertNotNull(sellList);
		System.out.println(sellList);
	}
	
	@Test
	public void 내정보관리_조회_테스트() {
		
		String memberId = "1111";
		
		MembersDTO selectInfo = mypageService.selectInfo(memberId);
		
		assertNotNull(selectInfo);
		System.out.println(selectInfo);
	}
	
	@Test
	public void 내정보관리_프로필_사진_인서트() {
	    AttachmentFileDTO attachment = new AttachmentFileDTO();
	    attachment.setFileOriginalName("img");
	    attachment.setFileDiv("profile");
	    attachment.setFilePath("c");
	    attachment.setFileDecoded("d");
	    attachment.setFileThumbnailChecking("YES");

	    mypageService.updateInfo(attachment);

	    // updateInfo() 메서드의 반환값이 void이므로, insertProfile 변수 대신에
	    // 출력문을 사용하여 updateInfo() 메서드가 정상적으로 실행되었는지 확인합니다.
	    System.out.println(attachment);
	}
	
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
		
		int insertAddress = mypageService.insertAddress(address, memberNo);

		log.info("insertAddress : {}", insertAddress);
	}
	
	
	
	
	

}
