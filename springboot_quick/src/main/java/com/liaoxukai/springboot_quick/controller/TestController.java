package com.liaoxukai.springboot_quick.controller;/*
 *@author:kai
 *@create:2019-11-2019/11/1-19:00
 */

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@RequestMapping(value = "emps")
@Controller
public class TestController {

//    @RequestMapping(value = "/hello")
//    public String hello(Map<String,String> map){
//
//        map.put("hellos","你好");
//
//        return "hello";
//    }

    @PostMapping(value = "login")
    public String login(@RequestParam("number") String number,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        session.setAttribute("login",number);

        if (!StringUtils.isEmpty(number)&&"123456".equals(password)){
            map.put("msg","登录成功");
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误!!!");
            return "login";
        }
    }
}
