package com.business.manager.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String encrypt(String rawContent) {
        try {
            // 创建MD5加密对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算MD5值
            byte[] messageDigest = md.digest(rawContent.getBytes());
            // 将byte数组转换为BigInteger表示
            BigInteger no = new BigInteger(1, messageDigest);
            // 将BigInteger转换为16进制字符串
            String hashtext = no.toString(16);
            // 补齐前面的0，使长度达到32位
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean isSample(String rawContent,String encryptContent){
        String rawEncryptContent = encrypt(rawContent);
        if (rawEncryptContent == null){
            return false;
        }
        if(rawEncryptContent.equals(encryptContent)){
            return true;
        }
        return false;



    }
}
