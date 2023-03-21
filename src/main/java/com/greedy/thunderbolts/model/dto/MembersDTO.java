package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MembersDTO {
	private int membersNo;
	private String membersName;
	private String membersId;
	private String membersPwd;
	private int membersTel;
	private Date membersRegDate;
	private int membersEntire;
}
