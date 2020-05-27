package com.example.dao;

import com.example.entity.MyUserInfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MyUserInfoMapper {
    int insert(MyUserInfo record);
    int insertSelective(MyUserInfo record);

    int deleteByPrimaryKey(Integer userid);
    int delUserByID( @Param("ids") List<String> ids);

    MyUserInfo selectByPrimaryKey(Integer userid);
    MyUserInfo findUserByName(String name);
    List<MyUserInfo> selectAllUser();

    int updateByPrimaryKeySelective(MyUserInfo record);
    int updateByPrimaryKey(MyUserInfo record);
}
