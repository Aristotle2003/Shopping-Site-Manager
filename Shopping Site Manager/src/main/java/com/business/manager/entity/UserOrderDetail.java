package com.business.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
* 用户订单详情信息
*/
public class UserOrderDetail implements Serializable {

    /**
    * 订单项的唯一标识
    */
    @JsonProperty("order_item_id")
    private Integer orderItemId;
    /**
    * 记录创建时间
    */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    /**
    * 记录更新时间，在更新时自动更新为当前时间戳
    */
    @JsonProperty("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date updateTime;
    /**
    * 订单项所属的店铺ID
    */
    @JsonProperty("shop_id")
    private Integer shopId;
    /**
    * 关联的订单ID
    */
    @JsonProperty("order_id")
    private Integer orderId;
    /**
    * 产品分类ID
    */
    @JsonProperty("category_id")
    private Integer categoryId;
    /**
    * 产品ID，用于标识具体的产品。
    */
    @JsonProperty("spu_id")
    private String spuId;
    /**
    * 产品SKU ID，可能表示具体规格的产品ID。
    */
    @JsonProperty("sku_id")
    private String skuId;
    /**
    * 用户ID，与订单项相关联的用户ID。
    */
    @JsonProperty("user_id")
    private Integer userId;
    /**
    * 购物车中该产品的数量。
    */
    private Integer count;
    /**
    * 产品名称。
    */
    @JsonProperty("spu_name")
    private String spuName;
    /**
    * 产品SKU名称。
    */
    @JsonProperty("sku_name")
    private String skuName;
    /**
    * 产品主图片路径。
    */
    private String pic;
    /**
    * 单个orderItem的配送类型，例如表示是否需要快递等。
    */
    @JsonProperty("delivery_type")
    private Integer deliveryType;
    /**
    * 加入购物车时间，记录了订单项加入购物车的时间。
    */
    @JsonProperty("shop_cart_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date shopCartTime;
    /**
    * 产品价格。
    */
    private Double price;
    /**
    * 商品总金额，可能是某个产品在订单项中的总价。
    */
    @JsonProperty("spu_total_amount")
    private Double spuTotalAmount;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Date getShopCartTime() {
        return shopCartTime;
    }

    public void setShopCartTime(Date shopCartTime) {
        this.shopCartTime = shopCartTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSpuTotalAmount() {
        return spuTotalAmount;
    }

    public void setSpuTotalAmount(Double spuTotalAmount) {
        this.spuTotalAmount = spuTotalAmount;
    }
}
