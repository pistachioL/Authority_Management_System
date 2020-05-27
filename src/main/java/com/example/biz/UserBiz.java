package com.example.biz;

import com.example.entity.MyUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBiz {
    List<MyUserInfo> selectAllUser();
    MyUserInfo findUserByName(String name);
    int insertSelective(MyUserInfo record);
   // int deleUserByID(@Param(ids));
}
