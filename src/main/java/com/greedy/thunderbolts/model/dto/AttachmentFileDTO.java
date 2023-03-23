package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AttachmentFileDTO {
	 
	private int fileCode;
	private String fileOriginalName;
	private String fileDiv;
	private int reviewCode;
	private int productOptionCode;
	private int noticeNo;
	private String filePath;
	private String fileDecoded;
	private Date fileDate;
	private String fileThumbnailChecking;
	private int membersNo;
}
