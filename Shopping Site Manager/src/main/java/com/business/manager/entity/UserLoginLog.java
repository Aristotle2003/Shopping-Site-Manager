package com.business.manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 用户登陆日志
*/
public class UserLoginLog implements Serializable {

    /**
    * 主键
    */
    private Integer logId;
    /**
    * 登陆用户
    */
    private Integer uid;
    /**
    * 登陆IP
    */
    private String ipAddress;
    /**
    * 登陆设备
    */
    private String device;
    /**
    * 登陆时间
    */
    private Date loginTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
