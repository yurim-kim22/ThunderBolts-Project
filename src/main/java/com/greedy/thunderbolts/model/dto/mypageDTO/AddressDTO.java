package com.greedy.thunderbolts.model.dto.mypageDTO;


import lombok.Data;

@Data
public class AddressDTO {
	
	private int addressesNo;
    //private MembersDTO members; //회원번호
	private String receiverName; //수령인
	private String addressesPostNo;
    private String addressesName; //주소
    private String addressesAdds; //상세주소
   

}
