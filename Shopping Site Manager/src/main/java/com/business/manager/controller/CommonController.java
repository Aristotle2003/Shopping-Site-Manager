package com.business.manager.controller;

import com.business.manager.entity.User;
import com.business.manager.param.LoginParam;
import com.business.manager.service.CaptchaService;
import com.business.manager.service.UserService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Resource
    private CaptchaService captchaService;

    @Resource
    private UserService userService;

    /**
     * 生成验证码
     * @param response
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response){
        captchaService.generateCaptcha(response);
    }

    /**
     * 用户登录
     * @param param 登录参数
     */
    @PostMapping("/login")
    public ResponseEntity login(HttpServletRequest request,LoginParam param){
        return userService.login(request,param) ;
    }
    /**
     * 注册用户信息
     * @param user 注册用户信息
     */
    @PostMapping("/register")
    public ResponseEntity register(HttpServletRequest request,@RequestBody User user){
        return userService.register(request,user) ;
    }
}
