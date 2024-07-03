package com.business.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
* 用户订单表=信息
*/
public class UserOrder implements Serializable {

    /**
    * 订单的唯一标识这是主键，用于唯一标识每个订单
    */
    @JsonProperty("order_id")
    private Integer orderId;
    /**
    * 订单创建时间
    */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    /**
    * 订单更新时间
    */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date updateTime;
    /**
    * 订单所属店铺的唯一标识
    */
    @JsonProperty("shop_id")
    private Integer shopId;
    /**
    * 下订单的用户的唯一标识，不能为空
    */
    @JsonProperty("user_id")
    private Integer userId;
    /**
    * 订单的配送类型
    */
    @JsonProperty("delivery_type")
    private Integer deliveryType;
    /**
    * 店铺名称
    */
    @JsonProperty("shop_name")
    private String shopName;
    /**
    * 订单的总值
    */
    private Double total;
    /**
    * 订单的状态
    */
    private Integer status;
    /**
    * 订单商品总数
    */
    @JsonProperty("all_count")
    private Integer allCount;
    /**
    * 订单的付款时间
    */
    @JsonProperty("pay_time")
    private Date payTime;
    /**
    * 订单的发货时间
    */
    @JsonProperty("delivery_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date deliveryTime;
    /**
    * 订单完成时间
    */
    @JsonProperty("finally_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date finallyTime;
    /**
    * 订单结算时间
    */
    @JsonProperty("settled_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date settledTime;
    /**
    * 订单取消时间
    */
    @JsonProperty("cancel_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date cancelTime;
    /**
    * 标识订单是否已支付
    */
    @JsonProperty("is_payed")
    private Integer isPayed;
    /**
    * 订单关闭原因，默认值也可以为NULL
    */
    @JsonProperty("close_type")
    private Integer closeType;
    /**
    * 用户订单删除状态，默认值为0
    */
    @JsonProperty("delete_status")
    private Integer deleteStatus;
    /**
    * 订单版本号
    */
    private String version;
    /**
    * 用户订单地址的唯一标识
    */
    @JsonProperty("order_addr_id")
    private Integer orderAddrId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getFinallyTime() {
        return finallyTime;
    }

    public void setFinallyTime(Date finallyTime) {
        this.finallyTime = finallyTime;
    }

    public Date getSettledTime() {
        return settledTime;
    }

    public void setSettledTime(Date settledTime) {
        this.settledTime = settledTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public Integer getCloseType() {
        return closeType;
    }

    public void setCloseType(Integer closeType) {
        this.closeType = closeType;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getOrderAddrId() {
        return orderAddrId;
    }

    public void setOrderAddrId(Integer orderAddrId) {
        this.orderAddrId = orderAddrId;
    }
}
