package com.ocean.main.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ocean.main.entity.User;

public class SessionFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        if(session==null){
            System.out.println("session失效！");
        }else {
            User user = (User)session.getAttribute("user");
            int userId = user!=null?user.getId():0;
            if(userId>0){
                System.out.println("用户已登录！");
            }else{
                System.out.println("用户未登录！");
                //自动拦截到用户登录页面
            }
        }
        request.getParameter("");
        System.out.println("进入过滤器");
        // TODO Auto-generated method stub
        chain.doFilter(request, response);
    }

    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
