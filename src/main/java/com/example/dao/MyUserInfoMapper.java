package com.example.dao;

import com.example.entity.MyUserInfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MyUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MyUserInfo record);
    int insertSelective(MyUserInfo record);

    MyUserInfo selectByPrimaryKey(Integer userid);
    MyUserInfo findUserByName(String name);
    List<MyUserInfo> selectAllUser();

    int updateByPrimaryKeySelective(MyUserInfo record);
    int updateByPrimaryKey(MyUserInfo record);
}
