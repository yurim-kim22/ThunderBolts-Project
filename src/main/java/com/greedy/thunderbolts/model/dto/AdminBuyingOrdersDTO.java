package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;
@Data
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
}
