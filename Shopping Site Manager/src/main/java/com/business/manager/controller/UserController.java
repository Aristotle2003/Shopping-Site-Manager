package com.business.manager.controller;

import com.business.manager.entity.User;
import com.business.manager.service.CaptchaService;
import com.business.manager.service.UserService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;


    /**
     * 查询指定用户信息
     * @param uid
     * @return
     */
    @GetMapping("/{uid}")
    public ResponseEntity userInfo(@PathVariable Integer uid){
        return ResponseEntity.SUCCESS(userService.userInfo(uid));
    }


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity update(HttpServletRequest request,User user){
        return userService.update(request,user);
    }


}
