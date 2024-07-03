package com.business.manager;

import com.business.manager.entity.UserOrderDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OrderForm implements Serializable {
    /**
     * 下单用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 下单物品列表
     */
    @JsonProperty("order_details")
    private List<UserOrderDetail> orderDetails;
    /**
     * 下单用户地址ID
     */
    @JsonProperty("order_address_id")
    private Integer orderAddressId;
    /**
     * 所属店铺Id
     */
    @JsonProperty("shop_id")
    private Integer shopId;
    /**
     * 所属店铺名称
     */
    @JsonProperty("shop_name")
    private String shopName;
    /**
     *
     */
    @JsonProperty("delivery_type")
    private Integer deliveryType;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<UserOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<UserOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(Integer orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }
}
