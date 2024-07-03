package com.business.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
* 订单地址信息
*/
public class OrderAddress implements Serializable {

    /**
    * 订单地址唯一标识
    */
    @JsonProperty("order_addr_id")
    private Integer orderAddrId;
    /**
    * 用户ID
    */
    @JsonProperty("user_id")
    private Integer userId;
    /**
    * 收货人。
    */
    private String consignee;
    /**
    * 省份ID
    */
    @JsonProperty("province_id")
    private Integer provinceId;
    /**
    * 省份名称
    */
    private String province;
    /**
    * 城市ID
    */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
    * 城市名称
    */
    private String city;
    /**
    * 区域ID
    */
    @JsonProperty("area_id")
    private Integer areaId;
    /**
    * 区域名称
    */
    private String area;
    /**
    * 具体地址
    */
    private String addr;
    /**
    * 邮政编码
    */
    @JsonProperty("post_code")
    private String postCode;
    /**
    * 手机号码
    */
    private String mobile;
    /**
    * 坐标经度
    */
    private String lng;
    /**
    * 坐标纬度
    */
    private String lat;
    /**
    * 记录创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    /**
    * 记录更新时间，在更新时自动更新为当前时间戳
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date updateTime;

    public Integer getOrderAddrId() {
        return orderAddrId;
    }

    public void setOrderAddrId(Integer orderAddrId) {
        this.orderAddrId = orderAddrId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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
}
