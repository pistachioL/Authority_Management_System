package com.example.controller;
import com.example.biz.UserBiz;
import com.example.entity.LayUITable;
import com.example.entity.MyUserInfo;
import com.example.util.MyConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {
    @Autowired
    private UserBiz userBizimpl;
    @RequestMapping("/toShowUserPage")

    public String toShowUserPage(Model model){
        List<MyUserInfo> userInfoList = userBizimpl.selectAllUser();
        model.addAttribute("userInfoList",userInfoList);
        model.addAttribute("name","liao");
        return "user/showUser";
    }
    @RequestMapping("/toShowUserLayui")
    public String toShowUserLayui(){
        return "user/showUserLayui";
    }
    @RequestMapping("/showUserLayui")
    @ResponseBody
    public LayUITable showUserLayui(Integer page, Integer limit){
        //开始分页
        PageHelper.startPage(page,limit);
        //开始查询
        List<MyUserInfo> userInfoList = userBizimpl.selectAllUser();
        //结束分页 pageInfo封装了分页之后的所有数据
        PageInfo<MyUserInfo> pageInfo = new PageInfo(userInfoList);
        LayUITable layUITable = new LayUITable();
        layUITable.setCode(0);
        layUITable.setMsg("返回消息");
        layUITable.setCount(pageInfo.getTotal());
        layUITable.setData(pageInfo.getList());
        return layUITable;
    }

    //添加用户
    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(MyUserInfo myUserInfo){
        int i = userBizimpl.insertSelective(myUserInfo);
        Map map = new HashMap<>();
        if(i > 0){
            map.put("code",MyConstants.successCode);
            map.put("message", MyConstants.SaveSuccessMsg);
        }
        else{
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.SaveFailMsg);
        }
        return map;
    }

//    //删除用户
//    @RequestMapping("/delUser")
//    @ResponseBody
//    public Object delUser(MyUserInfo myUserInfo){
//        int i = userBizimpl.
//
//
//    }
}

