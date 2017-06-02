package com.luvsea.stock.controller.user;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luvsea.common.basic.UtilString;
import com.luvsea.common.returnobject.ReturnObject;
import com.luvsea.common.util.UtilProperties;

@Controller
@RequestMapping("user")
public class UserController {
    
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response){
        
        try {
            String hostUrl = UtilProperties.getProWxByKey("wx.hostURL");
            String redirectURLAUTH = hostUrl+"/auth/toAuth";
            String authUrl = UtilProperties.getProWxByKey("wx.authURL");
            String redirectURLHTML = hostUrl+"/user/toHTML";//jump third part
            String urlByOpenId = hostUrl+"/user/toLogin";
            redirectURLHTML+=("?redirectURLOPENID="+urlByOpenId);
            authUrl+="?redirectURLAUTH="+URLEncoder.encode(redirectURLAUTH+"?redirectURLHTML="+redirectURLHTML,"utf-8");
            response.sendRedirect(authUrl);
        } catch (IOException e) {
            e.printStackTrace();
            log.debug("授权异常");
        }
    }
    
    //跳转到页面 第三方接收地址 统一登录 (入口3)
    @RequestMapping("toHTML")
    @ResponseBody
    public void toHTML(HttpServletRequest request, HttpServletResponse response){
        
        try {
            String redirect = null;
            @SuppressWarnings("unused")
            String openId = null;
            StringBuffer sb = new StringBuffer();
          //列出parameters参数
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String string = (String) params.nextElement();
                String values = request.getParameter(string);
                if("openid".equals(string)&&!UtilString.isEmpty(values)){
                    openId = values;
                    request.getSession().setAttribute("openId", values);
                }
                if("redirectURLOPENID".equals(string)&&!UtilString.isEmpty(values)){
                    redirect = values;
                }
                sb.append( (UtilString.isNull(sb.toString())?"?":"&")+string+"="+URLEncoder.encode(values,"utf-8"));
            }
            String finalUrl = redirect+sb.toString(); //只编码参数！
            response.sendRedirect(finalUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** logging......*/
    @RequestMapping("toLogin")
    @ResponseBody
    public ReturnObject<String> toLogin(HttpServletRequest request){
        
        ReturnObject<String> ret = new ReturnObject<>();
        try {
            String openId = request.getParameter("openid");
            System.out.println("得到最终的openId"+openId);
        } catch (Exception e) {
            ret.setMsg("登录异常");
        }
        return ret;
    }
    
    //或者是接收页面传过来的openid进行登录校验
    public void getUserByOpenid(){
        
    }
    
    /**
     * 用户注册
     */
    @RequestMapping("addUser")
    @ResponseBody
    public ReturnObject<String> addUser(){
        
        
        return new ReturnObject<String>();
    }
    

}
