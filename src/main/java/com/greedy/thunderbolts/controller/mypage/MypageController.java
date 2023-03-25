package com.greedy.thunderbolts.controller.mypage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.multipart.MultipartFile;

import com.greedy.thunderbolts.model.dto.AttachmentFileDTO;
import com.greedy.thunderbolts.model.dto.MembersDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.BuyListDTO;
import com.greedy.thunderbolts.model.dto.mypageDTO.SellListDTO;
import com.greedy.thunderbolts.model.service.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	//마이페이지 메인
	@GetMapping
	public String mypageMain(@AuthenticationPrincipal MembersDTO membersId, Model model) {
		
		String memberId = membersId.getMembersId();
		
	    log.info("[Controller] : {}", memberId );
	    
	    BuyListDTO buyList = mypageService.selectBuyList(memberId);
	    SellListDTO sellList = mypageService.selectSellList(memberId);

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    String formattedBuyDate = dateFormat.format(buyList.getOrder().getOrdersDate());
	    String formattedSellDate = dateFormat.format(sellList.getOrder().getOrdersDate());

	    model.addAttribute("buyList", buyList);
	    model.addAttribute("sellList", sellList);
	    model.addAttribute("memberId", memberId);
	    
	    model.addAttribute("buyDate", formattedBuyDate);
	    model.addAttribute("sellDate", formattedSellDate);

	    log.info("buyList : {}", buyList);
	    log.info("sellList : {}", sellList);

	    return "mypage/mypageMain";
	}
	
	//마이페이지 관심상품
	@GetMapping("/wish")
	public String wish(){
		
		return "mypage/wish";
	}
	
	//마이페이지 내정보관리 - 조회
	@GetMapping("/info")
	public String info(@AuthenticationPrincipal MembersDTO membersId, Model model){
		
		String memberId = membersId.getMembersId();
		
		MembersDTO selectInfo = mypageService.selectInfo(memberId);
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("selectInfo", selectInfo);
			
		return "mypage/information";
	}
	
	//마이페이지 내정보관리 - 수정
	@GetMapping("/modify")
	public String modify(@AuthenticationPrincipal MembersDTO membersId, Model model){

	    String memberId = membersId.getMembersId();

	    MembersDTO selectInfo = mypageService.selectInfo(memberId);
	    
	    

	    model.addAttribute("memberId", memberId);
	    model.addAttribute("selectInfo", selectInfo);

	    return "mypage/modify";
	}

	@PostMapping("/modify")
	public String modi(@AuthenticationPrincipal MembersDTO membersId, AttachmentFileDTO attachment,
	                    MultipartFile attachImage, Model model){
		
		String memberId = membersId.getMembersId();
		
		MembersDTO selectInfo = mypageService.selectInfo(memberId);
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("selectInfo", selectInfo);
		
		//파일
		
		
		log.info("[ThumbnailController] attachment request : {}", attachment);
		log.info("[ThumbnailController] attachImage request : {}", attachImage);
		
		String fileUploadDir = IMAGE_DIR + "original";//원본파일 경로
		
		File dir1 = new File(fileUploadDir);
		
		log.info("[ThumbnailController] dir1 : {}", dir1);
		
		/* 디렉토리가 없을 경우 생성한다. */
		if(!dir1.exists()) {
			dir1.mkdirs();
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
					
					/* DB에 저장할 파일의 정보 처리 */
					AttachmentFileDTO fileInfo = new AttachmentFileDTO();
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

				//File deleteFile = new File(attachment.getFilePath() + "/" + attachment.getFileOriginalName());
				
				deleteFile.delete();
			
		}
		
		mypageService.updateInfo(attachment);
		
		return "/mypage/information";
	}
	
	
	//주소록
	@GetMapping("/address")
	public String address(){
		
		return "mypage/address";
	}
	

}
