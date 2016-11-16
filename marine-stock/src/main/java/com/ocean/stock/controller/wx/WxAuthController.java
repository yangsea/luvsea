package com.ocean.stock.controller.wx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.returnobject.ReturnObject;
import com.ocean.wechat.common.util.UtilWechat;

@Controller
@RequestMapping("auth")
public class WxAuthController {
    
    /**
     * 获得openid,每个系统的唯一接口，不提供页面调用，用于重定向
     */
    @RequestMapping("getAuth")
    @ResponseBody
    public ReturnObject<String> auth(HttpServletRequest request,HttpServletResponse response){
        
        ReturnObject<String> ret = new ReturnObject<>();
        ret = UtilWechat.auth(request, response);
        return ret;
    }
    
    //授权
    @RequestMapping("toAuth")
    @ResponseBody
    public void toAuth(HttpServletResponse response,HttpServletRequest request){
        
        try {
//            String appId; 
            UtilWechat.authRedirect(response, "", "", "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
