package com.business.manager.service.impl;

import com.business.manager.dao.UserLoginLogDao;
import com.business.manager.entity.UserLoginLog;
import com.business.manager.service.UserLoginLogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserLoginLogImpl implements UserLoginLogService {
    @Resource
    UserLoginLogDao userLoginLogDao;

    @Override
    public int insert(HttpServletRequest request,Integer uid) {
        UserLoginLog userLoginLog = new UserLoginLog();
        String remoteAddr = request.getRemoteAddr();
        String browser = getBrowserType(request);
        userLoginLog.setLoginTime(new Date());
        userLoginLog.setIpAddress(remoteAddr);
        userLoginLog.setDevice(browser);
        userLoginLog.setUid(uid);
        return userLoginLogDao.insert(userLoginLog);
    }
    @Override
    public int insert(UserLoginLog loginLog) {
        return userLoginLogDao.insert(loginLog);
    }


    /**
     * 获取浏览器类型
     * @param request
     * @return
     */
    public static String getBrowserType(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "unknown";
        }

        userAgent = userAgent.toLowerCase();

        if (userAgent.contains("msie") || userAgent.contains("trident")) {
            return "Internet Explorer";
        } else if (userAgent.contains("edge")) {
            return "Edge";
        } else if (userAgent.contains("chrome")) {
            return "Chrome";
        } else if (userAgent.contains("firefox")) {
            return "Firefox";
        } else if (userAgent.contains("safari")) {
            return "Safari";
        } else if (userAgent.contains("opera")) {
            return "Opera";
        } else {
            return "unknown";
        }
    }
}
