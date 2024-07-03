package com.business.manager.entity;


import java.io.Serializable;

import java.util.Date;

/**
* 用户信息表
* users
*/
public class User implements Serializable {

    /**
    * 全平台用户的唯一ID。
    */
    private Integer uid;
    /**
    * 创建账户的时间戳
    */
    private Date createTime;
    /**
    * 更新的时间戳
    */
    private Date updateTime;
    /**
    * 用户名，用于登录账户
    */
    private String username;
    /**
    * 账户密码，经过加密处理存储
    */
    private String password;
    /**
    * 账户创建时的IP地址
    */
    private String createIp;
    /**
    * 账户状态，用整数表示， 1表示启用， 0表示禁用， -1表示删除
    */
    private Integer status;
    /**
    * 用户类型，区分不同的系统用户类型，例如普通用户、商家端、平台端等
    */
    private Integer sysType;
    /**
    * 租户ID，指明账户所属的租户
    */
    private Integer tenantId;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }
}
