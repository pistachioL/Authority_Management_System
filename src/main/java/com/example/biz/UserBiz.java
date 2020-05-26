package com.example.biz;

import com.example.entity.MyUserInfo;

import java.util.List;

public interface UserBiz {
    List<MyUserInfo> selectAllUser();
    MyUserInfo findUserByName(String name);
    int insertSelective(MyUserInfo record);
}
