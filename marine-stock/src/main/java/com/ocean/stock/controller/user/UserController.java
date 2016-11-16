package com.ocean.stock.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocean.common.returnobject.ReturnObject;

public class UserController {
    
    @RequestMapping("")
    @ResponseBody
    public ReturnObject<String> login(HttpServletRequest request, HttpServletResponse response){
        
        ReturnObject<String> ret = new ReturnObject<>();
        try {
            response.sendRedirect(".../auth/getAuth");
        } catch (IOException e) {
            e.printStackTrace();
            ret.setMsg("登录异常");
        }
        return ret;
    }
    
    

}
