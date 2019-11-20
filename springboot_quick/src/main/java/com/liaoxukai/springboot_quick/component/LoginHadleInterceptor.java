package com.liaoxukai.springboot_quick.component;/*
 *@author:kai
 *@create:2019-11-2019/11/4-11:53
 */

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginHadleInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object object=request.getSession().getAttribute("login");
        if (StringUtils.isEmpty(object))
        {
            request.setAttribute("msg","用户为空，请重新登录");
            request.getRequestDispatcher("/").forward(request,response);
            System.out.println("空session.getAttribute()："+object+",handler:"+handler);
            return false;
            //用户不存在
        }else {
            //用户存在
            System.out.println("非空session.getAttribute()："+object+",handler:"+handler);
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
