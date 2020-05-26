package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class loginController {
    @RequestMapping("/toShiro")
    public String toShiro(){
        return "shiro/shiro";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "shiro/login";
    }
    //登陆后
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("message","用户名错误");
            return "shiro/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "shiro/login";
        }
        return "shiro/shiro";
    }
}
