package com.business.manager.entity;

import java.util.List;

public class OrderBean {
    private UserOrder userOrder;
    private List<UserOrderDetail> orderDetails;

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public List<UserOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<UserOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
