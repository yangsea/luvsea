package com.ocean.wechat.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.returnobject.ReturnObject;
import com.ocean.wechat.common.util.UtilProperties;
import com.ocean.wechat.common.util.UtilWechat;
import com.ocean.wechat.common.util.UtilWechatJs;

@Controller
@RequestMapping("user")
public class UserController {
    
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response){
        
        try {
            String urlByOpenId = request.getParameter("backCallUrl");
            String hostUrl = UtilProperties.getProWxByKey("wx.hostURL");
            String redirectURLAUTH = hostUrl+"/auth/toAuth";
            String authUrl = UtilProperties.getProWxByKey("wx.authURL");
            String redirectURLHTML = hostUrl+"/user/toHTML";//jump third part
//            String urlByOpenId = hostUrl+"/user/toLogin";
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
                    redirect = values.substring(0, 5).contains("http")?values:"http://"+values;
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
    
    /**
     * 获取微信用户信息
     */
    @RequestMapping("getUser")
    @ResponseBody
    public ReturnObject<JSONObject> getUser(HttpServletRequest request){
        
        ReturnObject<JSONObject> returnObject = new ReturnObject<JSONObject>();
        try {
            JSONObject userJson = (JSONObject)request.getSession().getAttribute("userwx");//以openid作为键
            if(UtilString.isNull(userJson)){
                String accessToken = String.valueOf(request.getSession().getAttribute("accessTokenUser"));
                String openId = String.valueOf(request.getSession().getAttribute("openid"));
                userJson =  UtilWechat.getUserInfo(accessToken, openId);
                returnObject.setResult(userJson);
            }else{
                returnObject.setResult(userJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setSuccess(false);
            returnObject.setMsg("获取微信用户信息失败");
        }
        return returnObject;
    }
    
    @RequestMapping("getJsSign")
    @ResponseBody
    public ReturnObject<String> getJsSign(HttpServletRequest request){
        
        ReturnObject<String> returnObject = new ReturnObject<String>();
        String url = request.getParameter("url");
        String accessToken = String.valueOf(request.getSession().getServletContext().getAttribute("accessToken")); 
        String jsApiTicket = String.valueOf(request.getSession().getServletContext().getAttribute("jsApiTicket")); 
//        returnObject = UtilWechatJs.getJsSignature(url,accessToken,jsApiTicket,request.getSession().getServletContext());
        return returnObject;
    }
    
    /**
     * @Description 获取config注入信息  
     * @param request
     * @return
     * @author yanghaiyang   
     * @date 2016年12月27日 上午9:47:35
      */
     @RequestMapping("getConfigJs")
     @ResponseBody
     public ReturnObject<String>  getConfig(HttpServletRequest request){
         
         ReturnObject<String> returnObject = new ReturnObject<String>();
         try {
             String url  = request.getParameter("url");
             if(UtilString.isEmpty(url)){
                 returnObject.setMsg("url is not null !");
                 returnObject.setSuccess(false);
             }else{
//                     String accessToken = String.valueOf(request.getSession()
//                             .getServletContext().getAttribute("accessToken")); 
                     //jsapiticket
                     String jsApiTicket = String.valueOf(request.getSession()
                             .getServletContext().getAttribute("jsApiTicket")); 
                     returnObject = UtilWechatJs.getJsSignature(url ,jsApiTicket);
                     log.debug(returnObject.toString());
             }
         } catch (Exception e) {
             e.printStackTrace();
             returnObject.setMsg("程序出错，"+e.getMessage());
             returnObject.setSuccess(false);
         }
         return returnObject;
     }

}
