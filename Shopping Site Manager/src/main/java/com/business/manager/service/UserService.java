package com.business.manager.service;

import com.business.manager.entity.User;
import com.business.manager.param.LoginParam;
import com.business.manager.util.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    ResponseEntity login(HttpServletRequest request,LoginParam loginParam);
    User userInfo(Integer uid);

    ResponseEntity update(HttpServletRequest request, User user);

    ResponseEntity register(HttpServletRequest request,User user);
}
