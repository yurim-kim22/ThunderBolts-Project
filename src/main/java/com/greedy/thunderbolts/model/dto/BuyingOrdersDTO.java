package com.greedy.thunderbolts.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BuyingOrdersDTO {
    private int buyingOrderCode;
    private int membersNo;
    private int productOptionCode;

    private Date buyingOrderRegistdate;
    private int buyingOrderPrice;
    private String buyingOrderStatus;
    private Date buyingOrderCancellationDate;
    private Date buyingOrderSuccessingDate;
    private Date buyingOrderDeadlineDate;
}
