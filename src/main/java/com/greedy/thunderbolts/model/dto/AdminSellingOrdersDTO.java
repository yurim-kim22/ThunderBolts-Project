package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminSellingOrdersDTO {

	
		@Override
	public String toString() {
		return "AdminSellingOrdersDTO [sellingOrderNo=" + sellingOrderNo + ", productOptionCode=" + productOptionCode
				+ ", membersNo=" + membersNo + ", sellingOrderDate=" + sellingOrderDate + ", sellingOrderPrice="
				+ sellingOrderPrice + ", sellingOrderStatus=" + sellingOrderStatus + ", sellingOrderCancellationDate="
				+ sellingOrderCancellationDate + ", sellingOrderSuccessingDate=" + sellingOrderSuccessingDate
				+ ", sellingOrderDeadlineDate=" + sellingOrderDeadlineDate + ", members=" + members + "]";
	}
		private int sellingOrderNo;
		private int productOptionCode;
		private int membersNo;
		private Date sellingOrderDate;
		private int sellingOrderPrice;
		private String sellingOrderStatus;
		private Date sellingOrderCancellationDate;
		private Date sellingOrderSuccessingDate;
		private Date sellingOrderDeadlineDate;
		private AdminMembersDTO members;
		private AdminOrderDTO	OrdersDTO;

}
