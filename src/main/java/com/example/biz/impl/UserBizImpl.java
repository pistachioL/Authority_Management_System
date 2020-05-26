package com.example.biz.impl;

import com.example.biz.UserBiz;
import com.example.dao.MyUserInfoMapper;
import com.example.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.MyUserInfo;
import java.util.List;
import java.util.UUID;

//业务层
@Service
public class UserBizImpl implements UserBiz {
    @Autowired
    private MyUserInfoMapper myUserInfoMapper;
    @Override
    public List<MyUserInfo> selectAllUser() {
        return myUserInfoMapper.selectAllUser();
    }

    @Override
    public MyUserInfo findUserByName(String name) {
        MyUserInfo user = myUserInfoMapper.findUserByName(name);
        return user;
    }

    @Override
    public int insertSelective(MyUserInfo userInfo) {
        String salt = UUID.randomUUID().toString();
        String password = userInfo.getPassword();
        String encrytionPsd = ShiroUtil.encrytionBySalt(salt,password);
        userInfo.setPassword(encrytionPsd);
        userInfo.setSalt(salt);
        return myUserInfoMapper.insertSelective(userInfo);
    }


}