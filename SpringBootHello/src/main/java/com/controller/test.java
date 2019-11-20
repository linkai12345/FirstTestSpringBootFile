package com.controller;/*
 *@author:kai
 *@create:2019-10-2019/10/26-17:03
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

    @ResponseBody
    @RequestMapping("/emps")
    public String hello(){

        return "HelloWorld";
    }
}
