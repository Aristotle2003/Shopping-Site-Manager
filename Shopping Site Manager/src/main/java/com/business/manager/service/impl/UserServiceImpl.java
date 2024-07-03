package com.business.manager.service.impl;

import com.business.manager.constant.CommonConstant;
import com.business.manager.dao.UserDao;
import com.business.manager.entity.User;
import com.business.manager.enums.ResponseCodeEnum;
import com.business.manager.param.LoginParam;
import com.business.manager.service.UserLoginLogService;
import com.business.manager.service.UserService;
import com.business.manager.util.MD5Util;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    UserLoginLogService userLoginLogService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseEntity login(HttpServletRequest request,LoginParam loginParam) {
        if (loginParam.getCaptcha() == null) {
            return ResponseEntity.ERROR("请输入验证码", ResponseCodeEnum.ERROR);
        }

        if (loginParam.getRandomStr() != null){
            String cacheKey = CommonConstant.CAPTCHA + ":" + loginParam.getRandomStr();
            String captcha = stringRedisTemplate.opsForValue().get(cacheKey);
            if(captcha == null){
                return ResponseEntity.ERROR("验证码已过期", ResponseCodeEnum.ERROR);
            }
            if(!captcha.equals(loginParam.getCaptcha())){
                return ResponseEntity.ERROR("验证码错误", ResponseCodeEnum.ERROR);
            }
            stringRedisTemplate.delete(cacheKey);

        }else {
            boolean right = false;
            Set<String> captchaKeys = stringRedisTemplate.keys(CommonConstant.CAPTCHA);
            for (String captchaKey : captchaKeys) {
                String captcha = stringRedisTemplate.opsForValue().get(captchaKey);
                if(loginParam.getCaptcha().equals(captcha)){
                    right = true;
                    stringRedisTemplate.delete(captchaKey);
                    break;
                }

            }
            if (!right){
                return ResponseEntity.ERROR("验证码错误", ResponseCodeEnum.ERROR);
            }
        }

        if(loginParam == null || !StringUtils.hasLength(loginParam.getUsername()) ||
        !StringUtils.hasLength(loginParam.getPassword()) || !StringUtils.hasLength(loginParam.getCaptcha())
        ){
            return ResponseEntity.ERROR("请填写用户名密码及验证码", ResponseCodeEnum.PARAM_INVALID);
        }
        User loginUser = userDao.getUserByUsername(loginParam.getUsername());
        if(loginUser == null){
            return ResponseEntity.ERROR("用户名或密码错误", ResponseCodeEnum.ERROR);
        }
        if (MD5Util.isSample(loginParam.getPassword(),loginUser.getPassword())){
            String token = getToken();
            String cacheKey = CommonConstant.USER_TOKEN + ":" + token;
            stringRedisTemplate.opsForValue().set(cacheKey,loginUser.getUid().toString(),1, TimeUnit.DAYS);
            userLoginLogService.insert(request,loginUser.getUid());
            return ResponseEntity.SUCCESS(token,"请求成功");
        }else {
            return ResponseEntity.ERROR("用户名或密码错误", ResponseCodeEnum.ERROR);
        }
    }

    @Override
    public User userInfo(Integer uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public ResponseEntity update(HttpServletRequest request, User user) {
        User loginUser = (User)request.getAttribute(CommonConstant.USER_INFO);
        if (loginUser == null){
            return ResponseEntity.ERROR(ResponseCodeEnum.LOGIN);
        }
        if (user == null){
            return ResponseEntity.ERROR(ResponseCodeEnum.PARAM_INVALID);
        }
        if(!loginUser.getUid().equals(user.getUid())){
            return ResponseEntity.ERROR("请求非法",ResponseCodeEnum.ERROR);
        }
        int count = userDao.usernameCount(user.getUid(), user.getUsername());
        if(count > 0){
            return ResponseEntity.ERROR("用户名已存在",ResponseCodeEnum.ERROR);
        }

        String encrypt = MD5Util.encrypt(user.getPassword());
        int update =  userDao.update(user.getUsername(),encrypt,user.getUid());
        if(update > 0){
            return ResponseEntity.SUCCESS(null,"修改成功");
        }
        return ResponseEntity.ERROR("修改失败");
    }

    @Override
    public ResponseEntity register(HttpServletRequest request,User user) {
        if (user == null){
            return ResponseEntity.ERROR(ResponseCodeEnum.PARAM_INVALID);
        }
        User existUser = userDao.getUserByUsername(user.getUsername());
        if(existUser != null){
            return ResponseEntity.ERROR("用户名已存在",ResponseCodeEnum.ERROR);
        }
        User registerUser = new User();
        registerUser.setUsername(user.getUsername());

        String ipAddress = request.getRemoteAddr();
        registerUser.setCreateIp(ipAddress);
        String encrypt = MD5Util.encrypt(user.getPassword());
        registerUser.setPassword(encrypt);
        registerUser.setStatus(1);
        registerUser.setSysType(1);
        registerUser.setStatus(1);
        int insertCount = userDao.insertUser(registerUser);
        if(insertCount > 0){
            Map<String,Object> result = new HashMap<>();
            result.put("uid",registerUser.getUid());
            return ResponseEntity.SUCCESS(result,"注册成功");
        }
        return ResponseEntity.ERROR("注册失败");
    }

    public static String getToken(){
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        System.out.println("UUID: " + uuidString);
        return uuid.toString().replaceAll("-","");
    }
}
