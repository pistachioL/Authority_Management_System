package com.example.shiro;

import com.example.biz.UserBiz;
import com.example.entity.MyUserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserBiz userBiz;
//授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始");
        return null;
    }

//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证开始"); //用户名密码和数据库比对
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        MyUserInfo userByName = userBiz.findUserByName(usernamePasswordToken.getUsername());
//        if(!usernamePasswordToken.getUsername().equals(userByName)){
//            return null;
//        }
        if(userByName == null)
            return null;
        String sqlpassword = userByName.getPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userByName,sqlpassword,getName());
        return simpleAuthenticationInfo;
    }


}
