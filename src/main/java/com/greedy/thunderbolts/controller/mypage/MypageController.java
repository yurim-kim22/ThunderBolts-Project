package com.greedy.thunderbolts.controller.mypage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersAccountsDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.AddressDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.DetailDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;
import com.greedy.thunderbolts.model.service.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Value("${image.image-dir}")
	private String IMAGE_DIR;

	private final MypageService mypageService;
	private final PasswordEncoder passwordEncoder;
	private final MessageSourceAccessor messageSourceAccessor;

	@Autowired
	public MypageController(MypageService mypageService, PasswordEncoder passwordEncoder,
			MessageSourceAccessor messageSourceAccessor) {
		this.mypageService = mypageService;
		this.passwordEncoder = passwordEncoder;
		this.messageSourceAccessor = messageSourceAccessor;
	}

	// 마이페이지 메인
	@GetMapping
	public String mypageMain(@AuthenticationPrincipal MembersDTO membersId, Model model) {

		String memberId = membersId.getMembersId();
		int membersNo = membersId.getMembersNo();

		log.info("[Controller memberId] : {}", memberId);
		log.info("[Controller memberId] : {}", membersNo);

		model.addAttribute("memberId", memberId);
		
		//프로필사진
		AttachmentFileDTO selectprofile = mypageService.selectprofile(memberId);
		model.addAttribute("profile", selectprofile);
		
		log.info("[selectprofile] : {}", selectprofile);
		
		//판매 조건문 추가
		if(null != mypageService.selectSellList(memberId)) {
			SellListDTO sellList = mypageService.selectSellList(memberId);
			SimpleDateFormat sellDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String formattedSellDate = sellDateFormat.format(sellList.getOrder().getOrdersDate());
			model.addAttribute("sellList", sellList);
			model.addAttribute("sellDate", formattedSellDate);
			
			log.info("[] getOrders : {}", sellList.getOrder());

		}
		
		//구매 조건문 추가
		if(null != mypageService.selectBuyList(memberId)) {
			BuyListDTO buyList = mypageService.selectBuyList(memberId);
			SimpleDateFormat buyDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String formattedBuyDate = buyDateFormat.format(buyList.getOrder().getOrdersDate());
			model.addAttribute("buyList", buyList);
			model.addAttribute("buyDate", formattedBuyDate);
		}
		
		

		return "mypage/mypageMain";
		
	}

	
	
	
	
	
	// 마이페이지 구매내역
	@GetMapping("/mybuy")
	public String myBuy(@AuthenticationPrincipal MembersDTO members
			, Model model
			, @RequestParam(defaultValue="1") int page) {
		
		int memberNo = members.getMembersNo();
		
		Map<String, Object> selectbuyingList = mypageService.buyingList(memberNo, page);
		model.addAttribute("paging" , selectbuyingList.get("paging"));
		model.addAttribute("buyingList" , selectbuyingList.get("buyingList"));
		
		log.info("[selectbuyingList] selectbuyingList : {}", selectbuyingList);
		
		return "mypage/myBuy";
	}
	
	
	
	
	
	
	
	
	

	// 마이페이지 구매내역 상세
	@GetMapping("/mybuydetail")
	public String myBuyDetail(@RequestParam Long no, Model model) {
		
		DetailDTO mybuydetail = mypageService.detailBuy(no);
		log.info("[buydetail] detail : {}", mybuydetail);
		
		model.addAttribute("detail", mybuydetail);
		
		return "mypage/myBuyDetail";
	}
	
	
	// 마이페이지 판매내역 상세
	@GetMapping("/myselldetail")
	public String mySellDetail(@RequestParam Long no, Model model) {
		
		DetailDTO myselldetail = mypageService.detailSell(no);
		model.addAttribute("detail", myselldetail);
		
		return "mypage/mySellDetail";
	}

	
	
	
	
	
	
	
	
	
	
		
	

	// 마이페이지 판매내역
	@GetMapping("/mysell")
	public String mySell(@AuthenticationPrincipal MembersDTO members
			, Model model
			, @RequestParam(defaultValue="1") int page) {
		
		int memberNo = members.getMembersNo();
	
		Map<String, Object> selectSellingList = mypageService.sellingList(memberNo, page);
		model.addAttribute("paging" , selectSellingList.get("paging"));
		model.addAttribute("sellingList" , selectSellingList.get("sellingList"));
		
		log.info("[selectSellingList] selectSellingList : {}", selectSellingList);
		log.info("[paging] paging : {}", selectSellingList.get("paging"));
		
		return "mypage/mySell";
	}

	
	// 마이페이지 관심상품
	@GetMapping("/wish")
	public String wish(@AuthenticationPrincipal MembersDTO members
			, Model model
			, @RequestParam(defaultValue="1") int page) {
			
		int memberNo = members.getMembersNo();
		
		Map<String, Object> wishList = mypageService.wishList(memberNo, page);
		model.addAttribute("paging" , wishList.get("paging"));
		model.addAttribute("wishList" , wishList.get("wishList"));
		
		log.info("[wishList] wishList : {}", wishList);
		
		return "mypage/wish";
	}

	// 마이페이지 내정보관리 - 조회
	@GetMapping("/info")
	public String info(@AuthenticationPrincipal MembersDTO membersId, Model model) {

		String memberId = membersId.getMembersId();

		MembersDTO selectInfo = mypageService.selectInfo(memberId);

		model.addAttribute("memberId", memberId);
		model.addAttribute("selectInfo", selectInfo);

		return "mypage/information";
	}

	// 마이페이지 내정보관리 - 수정
	@GetMapping("/modify")
	public String modify(@AuthenticationPrincipal MembersDTO membersId, Model model) {

		String memberId = membersId.getMembersId();

		MembersDTO selectInfo = mypageService.selectInfo(memberId);

		model.addAttribute("memberId", memberId);
		model.addAttribute("selectInfo", selectInfo);

		return "mypage/modify";
	}

	// 내정보수정 누르면 조회로
	@PostMapping("/modify")
	public String modi(@AuthenticationPrincipal MembersDTO member, MembersDTO members,
			@RequestParam("memberPwdOld") String memberPwdOld, @RequestParam("membersPwd") String membersPwd,
			@RequestParam("name") String name, AttachmentFileDTO attachment, MultipartFile attachImage,
			RedirectAttributes redirectAttributes, Model model) {
		
		// 세션에서 현재 로그인한 사람의 아이디, 패스워드 가져오기
		String memberId = member.getMembersId();
		String currentUserPwd = member.getMembersPwd();
		log.info("[memberId] : {}", memberId);
		log.info("[currentUserPwd ] : {}", currentUserPwd);

		// 인풋에 입력한 패스워드 인코딩
		String encodedOldPwd = passwordEncoder.encode(memberPwdOld);
		log.info("[encodedOldPwd ] : {}", encodedOldPwd);
		// 인코딩한 패스워드(인풋에 입력한) 패스워드와 세션의 패스워드 일치하면
		if (!passwordEncoder.matches(currentUserPwd, encodedOldPwd)) {
			
			/*
			 * redirectAttributes.addFlashAttribute("errorMessage",
			 * "The provided password does not match the current password.");
			 */

			// DTO에 새로운 비밀번호와 이름을 set
			MembersDTO membersDTO = new MembersDTO();
			membersDTO.setMembersPwd(passwordEncoder.encode(membersPwd));
			membersDTO.setMembersName(name);
			
			mypageService.modifyInfo(membersDTO, memberId);
			
			/*
			 * //성공시 alert redirectAttributes.addFlashAttribute("message",
			 * messageSourceAccessor.getMessage("myInfo.update"));
			 * log.info("[redirectAttributes] : {}",
			 * redirectAttributes.addFlashAttribute("message",
			 * messageSourceAccessor.getMessage("myInfo.update")));
			 */
			
			// return "redirect:/mypage/info";
		}

		log.info("[password == ] : {}", passwordEncoder.matches(currentUserPwd, encodedOldPwd));

		// 내정보수정페이지에서 로그인한 회원 아이디, 이름 출력
		MembersDTO selectInfo = mypageService.selectInfo(memberId);

		// 파일

		log.info("[ThumbnailController] attachImage request : {}", attachImage);

		String fileUploadDir = IMAGE_DIR + "original";// 원본파일 경로

		File dir1 = new File(fileUploadDir);

		log.info("[ThumbnailController] dir1 : {}", dir1);

		/* 디렉토리가 없을 경우 생성한다. */
		if (!dir1.exists()) {
			dir1.mkdirs();
			log.info("[dir1] dir1 : {}", dir1.exists());
		}

		try {
 
			/* 4개의 input type=file이 서버로 전송 되어 List<MultipartFile> attachImage에 담겼다. */

			/* 첨부파일이 실제로 있는 경우에만 로직 수행 */
			if (attachImage.getSize() > 0) {

				String originalFileName = attachImage.getOriginalFilename();
				log.info("[ThumbnailController] originalFileName : {}", originalFileName);

				String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
				String savedFileName = UUID.randomUUID().toString() + ext;

				log.info("[ThumbnailController] savedFileName : {}", savedFileName);

				/* 서버의 설정 디렉토리에 파일 저장하기 */
				attachImage.transferTo(new File(fileUploadDir + "/" + savedFileName));

				/* DB에 저장할 파일의 정보 처리 AttachmentFileDTO fileInfo = new AttachmentFileDTO(); */

				attachment.setFileOriginalName(originalFileName);
				attachment.setFileDiv("profile");
				attachment.setFilePath("/upload/image/original/");
				attachment.setFileDecoded(savedFileName);
				attachment.setFileThumbnailChecking("N");

			}

		} catch (Exception e) {
			e.printStackTrace();
			/* 실패 시 이미 저장 된 파일을 삭제한다. */

			File deleteFile = new File(attachment.getFilePath(), attachment.getFileOriginalName());

			// File deleteFile = new File(attachment.getFilePath() + "/" +
			// attachment.getFileOriginalName());

			deleteFile.delete();

		}
		
		  if(null != attachment.getFileOriginalName()) {
			  mypageService.insertProfile(attachment);
			  log.info("[ThumbnailController] attachment request : {}", attachment);
		  }
		 

		return "redirect:/mypage/info";
	}

	// 주소록
	@GetMapping("/address")
	public String addressMain(@AuthenticationPrincipal MembersDTO members
			, AddressDTO address
			, Model model
			, @RequestParam(defaultValue="1") int page) {
		
		int memberNo = members.getMembersNo();
		
		//주소페이징
		//Map<String, Object> addressMap = mypageService.selectAddressList(memberNo, page);

		Map<String, Object> selectAddressList = mypageService.selectAddressList(memberNo, page);
		model.addAttribute("paging" , selectAddressList.get("paging"));
		model.addAttribute("addressList" , selectAddressList.get("addressList"));
		
		
		log.info("[selectAddressList] selectAddress : {}", selectAddressList);
		log.info("[paging] paging : {}", selectAddressList.get("paging"));

		return "mypage/address";
	}

	// 주소록 추가
	@PostMapping("/address")
	public String address(@AuthenticationPrincipal MembersDTO members, AddressDTO address, Model model,
			RedirectAttributes rttr) {

		int memberNo = members.getMembersNo();
		log.info("[memberNo] : {}", memberNo);
		log.info("[address] : {}", address);

		int insertAddress = mypageService.insertAddress(address, memberNo);

		log.info("[insertAddress] : {}", insertAddress);

		if (insertAddress == 0) {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("address.registerror"));
		} else {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("address.regist"));
		}

		return "redirect:/mypage/address";
	}

	// 정산계좌
	@GetMapping("/bank")
	public String bankMain(@AuthenticationPrincipal MembersDTO members, MembersAccountsDTO account, Model model) {

		int memberNo = members.getMembersNo();
		log.info("[memberNo] : {}", memberNo);

		MembersAccountsDTO selectAccounts = mypageService.selectAccounts(memberNo);
		model.addAttribute("accounts", selectAccounts);

		log.info("[selectAccounts] : {}", selectAccounts);

		return "mypage/bank";
	}

	// 정산계좌 추가
	@PostMapping("/bank")
	public String bank(@AuthenticationPrincipal MembersDTO members, MembersAccountsDTO account, Model model,
			RedirectAttributes rttr) {

		int memberNo = members.getMembersNo();
		log.info("[memberNo] : {}", memberNo);
		log.info("[account] : {}", account);

		int inserAccounts = mypageService.inserAccounts(account, memberNo);
		log.info("[insertAddress] : {}", inserAccounts);

		if (inserAccounts == 0) {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("account.registerror"));
		} else {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("account.regist"));
		}

		return "redirect:/mypage/bank";
	}
	
	//정산계좌 수정
	@PostMapping("/bankModify")
	public String bankModify(@AuthenticationPrincipal MembersDTO members, MembersAccountsDTO account, Model model,
			RedirectAttributes rttr) {

		int memberNo = members.getMembersNo();
		log.info("[memberNo] : {}", memberNo);
		log.info("[account] : {}", account);

		int modifyAccounts = mypageService.modifyAccounts(account, memberNo);
		log.info("[modifyAccounts] : {}", modifyAccounts);

		if (modifyAccounts == 0) {
			rttr.addFlashAttribute("messageModify", messageSourceAccessor.getMessage("account.modifyerror"));
		} else {
			rttr.addFlashAttribute("messageModify", messageSourceAccessor.getMessage("account.modify"));
		}

		return "redirect:/mypage/bank";
	}
	
	
	

}