package com.luvsea.wechat.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luvsea.common.basic.UtilString;
import com.luvsea.common.http.UtilHttpClient;
import com.luvsea.wechat.entity.UserWx;
import com.luvsea.wechat.service.WechatService;

@Service
public class WechatServiceImpl implements WechatService {

    private  String appId;
    private  String secret;
    private  String redirectUrl;
    private  String redirectUrlCustom;
    
//    @Override
//    public void authUnify(HttpServletRequest request, HttpServletResponse response) {
//
//        //getcode by redirecturi
//        try {
//            String redirect = null;
//            @SuppressWarnings("unused")
//            String openId = null;
//            StringBuffer sb = new StringBuffer();
//          //列出parameters参数
//            Enumeration<String> params = request.getParameterNames();
//            while (params.hasMoreElements()) {
//                String string = (String) params.nextElement();
//                String values = request.getParameter(string);
//                if("openid".equals(string)&&!UtilString.isEmpty(values)){
//                    openId = values;
//                    request.getSession().setAttribute("openId", values);
//                }
//                if("redirectURLs".equals(string)&&!UtilString.isEmpty(values)){
//                    redirect = values;
//                }
//                sb.append( (UtilString.isNull(sb.toString())?"?":"&")+string+"="+values);
//            }
//            String finalUrl = sb.insert(0, redirect).toString();
//            response.sendRedirect(finalUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public String getOpenId(HttpServletRequest request, HttpServletResponse response) {
//
//        //get openid by code
//        //认证后这里被重定向
//
//        HttpSession session = request.getSession();
//        boolean isValidCode = true;
//        String code = request.getParameter("code");
//        String state = request.getParameter("state");
//      //检查是否已验证或者验证是否通过
//        if (code == null || code.equals("authdeny")) {
//            isValidCode = false;
//        }
//      //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
//        if (isValidCode && session.getAttribute("openId") == null) {
//                try {
//                     JSONObject obj = getAccessToken(appId,secret, code);
//                    String token = obj.getString("access_token");
//                    String openid = obj.getString("openid");
//                    request.getSession().setAttribute("openId", openid);
//                    //根据openid查询数据库中数据，，写在各自项目中
//                    JSONObject user  = getUserInfo(token, openid);
//    //                  UserWx userWx = JSONObject.toJavaObject(user, UserWx.class);
//                    UserWx userWx = new UserWx();
//                    userWx.setOpenid(String.valueOf(user.get("openid")));
//                    userWx.setNickname(String.valueOf(user.get("nickname")));
//                    if(null!=user.get(user.get("sex"))&&!"".equals(String.valueOf(user.get("sex")))){
//                        userWx.setSex(Integer.valueOf(String.valueOf(user.get("sex"))));
//                    }
//                    userWx.setProvince(String.valueOf(user.get("province")));
//                    userWx.setCity(String.valueOf(user.get("city")));
//                    userWx.setCountry(String.valueOf(user.get("country")));
//                    userWx.setHeadimgurl(String.valueOf(user.get("headimgurl")));
//                    session.setAttribute("userWx", userWx);
//                    session.setAttribute("state", state);
//                    return openid;
//                } catch (IOException | URISyntaxException e) {
//                    e.printStackTrace();
//                }
//        }else{
//            String openId = String.valueOf(request.getSession().getAttribute("openId"));
//            return openId;
//        }
//        return null;
//    }

    @Override
    public String getUser(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
    * @Description  认证跳转
    * @author yanghaiyang   
     * @throws UnsupportedEncodingException 
    * @date 2016年11月9日 下午5:01:39
     */
    public void authRedirect(HttpServletRequest request, HttpServletResponse response) 
            throws UnsupportedEncodingException{
        
        //rdirecturl to...
        //跳转后转到回调地址 exm luvsea.iask.in 
        //比如说这里的getopenid接口 ，获取openid后对接业务
        //记得openid要放到session中，作为已登录标识，避免拦截器后续处理麻烦，
        //可以使用authunify统一放入，然后再重定向到目标页面，使用params组织动态放入页面与参数
        //startconfig
        String serviceUrl = URLEncoder.encode( redirectUrl , "utf-8");
        //如果session未空或者取消授权，重定向到授权页面
//        if (( session.getAttribute("uid") == null)) {
            //--最终审议，重新点击必须重新授权
            StringBuilder oauth_url = new StringBuilder();
            oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
            oauth_url.append("appid=").append(appId);
            oauth_url.append("&redirect_uri=").append(serviceUrl);
            oauth_url.append("&response_type=code");
            oauth_url.append("&scope=snsapi_userinfo");
            oauth_url.append("&state="+redirectUrlCustom+"#wechat_redirect");
            try {
                response.sendRedirect(oauth_url.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
    }

    /**
     * 通过code换取网页授权access_token
     * @throws URISyntaxException 
     * @throws IOException 
     * @throws ClientProtocolException 
     * */
    public JSONObject getAccessToken(String appid, String secret,
            String code) throws ClientProtocolException, IOException, URISyntaxException {
        String apiUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        JSONObject jo = new JSONObject();
        jo.put("appid", appid);
        jo.put("secret", secret);
        jo.put("code", code);
        jo.put("grant_type", "authorization_code");
        String params  = JSON.toJSONString(jo);
        String response  = UtilHttpClient.getPostResponse(params, apiUrl);
        return JSON.parseObject(response);
    }
    
    //获取用户信息
    public JSONObject getUserInfo(String accessToken, String openid) 
            throws ClientProtocolException, IOException, URISyntaxException {

        String host = "https://api.weixin.qq.com/sns/userinfo?";
        JSONObject jo = new JSONObject();
        jo.put("access_token", accessToken);
        jo.put("openid", openid);
        jo.put("lang", "zh_CN");
        String params  = JSON.toJSONString(jo);
        String response  = UtilHttpClient.getGetResponse(params, host);
        return JSON.parseObject(response);
    }

    @Override
    public String getOpenId(HttpServletRequest request, HttpServletResponse response) {

        //get openid by code
        boolean isValidCode = true;
        String code = request.getParameter("code");
      //检查是否已验证或者验证是否通过
        if (code == null || code.equals("authdeny")) {
            isValidCode = false;
        }
      //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
        if (isValidCode) {
                try {
                     JSONObject obj = getAccessToken(appId,secret, code);
                    String openid = obj.getString("openid");
                    return openid;
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
    
    /**
     * 中转服务器，任意跳转获得openid
     */
    @Override
    public void authUnify(HttpServletRequest request, HttpServletResponse response) {

        //getcode by redirecturi
        String  callBackUri = request.getParameter("redirectUri");
        String openId = getOpenId(request, response);
        try {
            response.sendRedirect(callBackUri+"?openid="+openId);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
