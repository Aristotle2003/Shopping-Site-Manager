package com.business.manager.service;

import com.business.manager.entity.UserLoginLog;
import jakarta.servlet.http.HttpServletRequest;

public interface UserLoginLogService {
    int insert(HttpServletRequest request, Integer uid);
    int insert(UserLoginLog loginLog);
}
