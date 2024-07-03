package com.business.manager.config.interceptor;

import com.alibaba.fastjson2.JSON;
import com.business.manager.constant.CommonConstant;
import com.business.manager.dao.UserDao;
import com.business.manager.entity.User;
import com.business.manager.enums.ResponseCodeEnum;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

@Component
public class ApiInterceptor implements HandlerInterceptor {
    private final static String TOKEN = "token";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserDao userDao;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //如果是登陆请求则直接放过
        if(path.contains("/login")){
            return true;
        }
        String token =request.getHeader(TOKEN);
        if (token == null) {
            ResponseEntity<Object> error = ResponseEntity.ERROR(ResponseCodeEnum.LOGIN);

            response.getWriter().print(JSON.toJSONString(error));
            return false;
        }

        String cacheKey = CommonConstant.USER_TOKEN + ":" + token;
        String userId = stringRedisTemplate.opsForValue().get(cacheKey);
        if (userId == null){
            ResponseEntity<Object> error = ResponseEntity.ERROR(ResponseCodeEnum.LOGIN_EXPIRED);
            response.getWriter().print(JSON.toJSONString(error));
            return false;
        }

        User user = userDao.getUserById(Integer.parseInt(userId));
        if(user == null){
            ResponseEntity<Object> error = ResponseEntity.ERROR(ResponseCodeEnum.LOGIN);
            response.getWriter().print(JSON.toJSONString(error));
            return false;
        }
        request.setAttribute(CommonConstant.USER_INFO,user);
        return true;
    }
}
