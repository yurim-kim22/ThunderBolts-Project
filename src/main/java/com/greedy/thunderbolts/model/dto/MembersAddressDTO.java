package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MembersAddressDTO {
	
	private int addressesNo;
    private int membersNo; //회원번호
    private String addressesName; //주소
    private String addressesPostNo;
    private String addressesAdds; //상세주소
    private String receiverName; //수령인
}
