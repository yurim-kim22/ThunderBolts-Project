package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminBuyingOrdersDTO {
    private int buyingOrderCode;
    private int membersNo;
    private int productOptionCode;
    private Date buyingOrderRegistdate;
    private int buyingOrderPrice;
    private String buyingOrderStatus;
    private Date buyingOrderCancellationDate;
    private Date buyingOrderSuccessingDate;
    private Date buyingOrderDeadlineDate;
    private AdminMembersDTO members;
    private AdminOrderDTO orders;
	@Override
	public String toString() {
		return "AdminBuyingOrdersDTO [buyingOrderCode=" + buyingOrderCode + ", membersNo=" + membersNo
				+ ", productOptionCode=" + productOptionCode + ", buyingOrderRegistdate=" + buyingOrderRegistdate
				+ ", buyingOrderPrice=" + buyingOrderPrice + ", buyingOrderStatus=" + buyingOrderStatus
				+ ", buyingOrderCancellationDate=" + buyingOrderCancellationDate + ", buyingOrderSuccessingDate="
				+ buyingOrderSuccessingDate + ", buyingOrderDeadlineDate=" + buyingOrderDeadlineDate + ", members="
				+ members + "]";
	}
}
