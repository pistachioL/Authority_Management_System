package com.example.shiro;

import com.example.util.MyConstants;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {
//加盐加密
    public static String encrytionBySalt(String salt,String msg){
        String algorithmName = MyConstants.algorithmName;
        int hashIterations = MyConstants.hashIterations;
        SimpleHash simpleHash = new SimpleHash(algorithmName,msg,salt,hashIterations);  //加密算法　明文　盐值　加密次数
        return simpleHash.toString();
    }
}
