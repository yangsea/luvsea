package com.luvsea.tooth.controller.wx;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luvsea.common.util.UtilProperties;
import com.luvsea.wechat.common.util.UtilWechat;

@Controller
@RequestMapping("auth")
public class WxAuthController {
    
    /**
     * 获得openid,每个系统的唯一接口，不提供页面调用，用于重定向 （入口1）
     */
    @RequestMapping("getAuth")
    @ResponseBody
    public void auth(HttpServletRequest request,HttpServletResponse response){
        
        try {
            // use test
            String redirectURLAUTH = request.getParameter("redirectURLAUTH");
            String appId = UtilProperties.getProWxByKey("wx.appId");
            String secret = UtilProperties.getProWxByKey("wx.secret");
            //request包含所需要跳转的url
            UtilWechat.authRedirect(response,appId,secret,redirectURLAUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * 授权后回调（入口2）
     */
    @RequestMapping("toAuth")
    @ResponseBody
    public void toAuth(HttpServletResponse response,HttpServletRequest request){
        
        UtilWechat.auth(request,response);
    }

}
