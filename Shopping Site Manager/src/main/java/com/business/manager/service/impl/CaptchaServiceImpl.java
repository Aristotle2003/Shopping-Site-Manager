package com.business.manager.service.impl;

import com.business.manager.constant.CommonConstant;
import com.business.manager.service.CaptchaService;
import com.business.manager.util.ImageCode;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void generateCaptcha(HttpServletResponse response) {
        ImageCode imageCode = ImageCode.generate();
        response.setContentType("image/png");
        BufferedImage bufferedImage = imageCode.getBufferedImage();
        try {
            //redisTemplate.opsForValue().set();
            String captchaId = generateCaptchaId();
            String cacheKey = CommonConstant.CAPTCHA + ":" + captchaId;
            //设置验证码120秒内是有效的
            stringRedisTemplate.opsForValue().set(cacheKey,imageCode.getValidateCode(),2, TimeUnit.MINUTES);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            response.addHeader("randomStr",captchaId);
            byteArrayOutputStream.writeTo(response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String generateCaptchaId(){
        Date now = new Date();
        Long second = now.getTime()/ 1000L;
        long random = BigDecimal.valueOf(Math.random()).multiply(BigDecimal.valueOf(100000)).setScale(0, RoundingMode.DOWN).longValue();
        return String.valueOf(second) + String.format("%06d",random);


    }

    public static void main(String[] args) {
        System.out.println(Math.random());
    }
}
