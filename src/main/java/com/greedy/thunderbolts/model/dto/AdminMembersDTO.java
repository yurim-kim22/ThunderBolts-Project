package com.greedy.thunderbolts.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AdminMembersDTO {
	private int membersNo;
	private String membersName;
	private String membersId;
	private String membersPwd;
	private String membersTel;
	private Date membersRegDate;
	private String membersEntire;
	private List<AuthRoleDTO> authRoleList;
}
