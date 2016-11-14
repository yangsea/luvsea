package com.ocean.common.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.encrypt.UtilSha14Wx;
import com.ocean.common.enumeration.EnumHost;
import com.ocean.common.enumeration.EnumWx;
import com.ocean.common.http.OLDUtilHttpClient;
import com.ocean.common.returnobject.ReturnObject;

public class UtilOAuthWx {
        
        @Autowired
//        private static UserWxService userWxService;

        public static final String DOMAIN_LOGIN = "checkin.ycwemedia.com/wx/login.html";
        public static final String DOMAIN_CHECKIN = "checkin.ycwemedia.com/wx/index.html";

        public static void OAuthLogin(HttpServletRequest request,
                HttpServletResponse response) throws IOException, URISyntaxException {
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            boolean isValidCode = true;
            String serviceUrl = URLEncoder.encode( "http://" + DOMAIN_LOGIN , "utf-8");
//            + request.getRequestURI()
            //检查是否已验证或者验证是否通过
            if (code == null || code.equals("authdeny")) {
                isValidCode = false;
            }
            //如果session未空或者取消授权，重定向到授权页面
            if ((!isValidCode) && session.getAttribute("user") == null) {
                StringBuilder oauth_url = new StringBuilder();
                oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
                oauth_url.append("appid=").append(EnumWx.appId.getValues());
                oauth_url.append("&redirect_uri=").append(serviceUrl);
                oauth_url.append("&response_type=code");
                oauth_url.append("&scope=snsapi_userinfo");
                oauth_url.append("&state=123#wechat_redirect");
                response.sendRedirect(oauth_url.toString());
                System.out.println(oauth_url.toString());
                return;
            }
            //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
            if (isValidCode && session.getAttribute("user") == null) {
                    JSONObject obj = UtilOAuthWx.getAccessToken(EnumWx.appId.getValues(),EnumWx.secret.getValues(), code);
//                    String token = obj.getString("access_token");
//                    String openid = obj.getString("openid");
                    response.getWriter().print(obj);
//                    JSONObject user = UtilOAuthWx.getUserInfo(token, openid, code);
////                    UserWxService memberService = (UserWxService) WebAppContext.getObject("UserWxService");
//                    UserWx userWx = JSONObject.toJavaObject(user, UserWx.class);
//                    userWx = userWxService.saveOrUpdate(userWx);
//                    session.setAttribute("user", userWx);
            }
        }
        
        public static void OAuthCheckin(HttpServletRequest request,
                HttpServletResponse response) throws IOException, URISyntaxException {
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            boolean isValidCode = true;
            String serviceUrl = URLEncoder.encode( "http://" + DOMAIN_CHECKIN , "utf-8");
//            + request.getRequestURI()
            //检查是否已验证或者验证是否通过
            if (code == null || code.equals("authdeny")) {
                isValidCode = false;
            }
            //如果session未空或者取消授权，重定向到授权页面
            if ((!isValidCode) && session.getAttribute("user") == null) {
                StringBuilder oauth_url = new StringBuilder();
                oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
                oauth_url.append("appid=").append(EnumWx.appId.getValues());
                oauth_url.append("&redirect_uri=").append(serviceUrl);
                oauth_url.append("&response_type=code");
                oauth_url.append("&scope=snsapi_userinfo");
                oauth_url.append("&state=123#wechat_redirect");
                response.sendRedirect(oauth_url.toString());
                System.out.println(oauth_url.toString());
                return;
            }
            //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
            if (isValidCode && session.getAttribute("user") == null) {
                    JSONObject obj = UtilOAuthWx.getAccessToken(EnumWx.appId.getValues(),EnumWx.secret.getValues(), code);
//                    String token = obj.getString("access_token");
//                    String openid = obj.getString("openid");
                    response.getWriter().print(obj);
//                    JSONObject user = UtilOAuthWx.getUserInfo(token, openid, code);
////                    UserWxService memberService = (UserWxService) WebAppContext.getObject("UserWxService");
//                    UserWx userWx = JSONObject.toJavaObject(user, UserWx.class);
//                    userWx = userWxService.saveOrUpdate(userWx);
//                    session.setAttribute("user", userWx);
            }
        }


        /**
         * 获取授权令牌
         * @throws URISyntaxException 
         * @throws IOException 
         * @throws ClientProtocolException 
         * */
        public static JSONObject getAccessToken(String appid, String secret,
                String code) throws ClientProtocolException, IOException, URISyntaxException {
            String apiUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
            JSONObject jo = new JSONObject();
            jo.put("appid", appid);
            jo.put("secret", secret);
            jo.put("code", code);
            jo.put("grant_type", "authorization_code");
            String params  = JSON.toJSONString(jo);
            String response  = OLDUtilHttpClient.getGetResponse(params, apiUrl);
            return JSON.parseObject(response);
        }

        //获取用户信息
        public static JSONObject getUserInfo(String token, String openid, String code) throws ClientProtocolException, IOException, URISyntaxException {

            String host = "https://api.weixin.qq.com/sns/userinfo?";
            JSONObject jo = new JSONObject();
            jo.put("access_token", token);
            jo.put("openid", openid);
            jo.put("code", code);
            jo.put("lang", "zh_CN");
            String params  = JSON.toJSONString(jo);
            String response  = OLDUtilHttpClient.getGetResponse(params, host);
            return JSON.parseObject(response);
        }

        /**
        * @Description 获取普通access_token  
        * @author yanghaiyang   
         * @throws URISyntaxException 
         * @throws IOException 
         * @throws ClientProtocolException 
        * @date 2016年9月5日 下午6:01:19
         */
        public static String getAccessToken() throws ClientProtocolException, IOException, URISyntaxException{
            
            JSONObject jo = new JSONObject();
            jo.put("grant_type","client_credential");
            jo.put("appid",EnumWx.appId.getValues());
            jo.put("secret", EnumWx.secret);
            String response = OLDUtilHttpClient.getGetResponse(JSON.toJSONString(jo), EnumHost.accessTokenHost.getValue());
            JSONObject reJo = JSON.parseObject(response);
            //获取access_token
            String accessToken = String.valueOf(reJo.get("access_token"));
            return accessToken;
        }
        
        /**
        * @Description 获取jsapi_ticket  
        * @return
        * @author yanghaiyang   
         * @throws URISyntaxException 
         * @throws IOException 
         * @throws ClientProtocolException 
        * @date 2016年9月5日 下午6:03:36
         */
        public static String getTicket() throws ClientProtocolException, IOException, URISyntaxException{
            
            JSONObject jo = new JSONObject();
            jo.put("access_token", getAccessToken());
            String response = OLDUtilHttpClient.getGetResponse(JSON.toJSONString(jo), EnumHost.ticketHost.getValue());
            JSONObject retJo = JSONObject.parseObject(response);
            String ticket  = String.valueOf(retJo.get("ticket"));
            return ticket;
        }
        
        //js签名
        public static ReturnObject<String> getWxConfig() throws ClientProtocolException, IOException, URISyntaxException{
            
            ReturnObject<String> returnObject = new ReturnObject<String>();
            List<String> params = new ArrayList<String>();  
            String nonceStr = UtilString.nonceStr(15);
            String timestamp = String.valueOf(System.currentTimeMillis());
            String url = "";
            String ticket = getTicket();
            params.add("yang123123123");  
            params.add(timestamp);  
            params.add(nonceStr);
            params.add(url);
            params.add(ticket);
            //1. 将token、timestamp、nonce三个参数进行字典序排序  
            Collections.sort(params, new Comparator<String>() {  
                @Override  
                public int compare(String o1, String o2) {  
                    return o1.compareTo(o2);  
                }  
            });  
            //2. 将三个参数字符串拼接成一个字符串进行sha1加密  
            String signature = UtilSha14Wx.encode(params.get(0) + params.get(1) + params.get(2)+ params.get(3)+ params.get(4));  
            JSONObject jo = new JSONObject();
            jo.put("timestamp", timestamp);
            jo.put("nonceStr",nonceStr);
            jo.put("url","");
            jo.put("ticket", ticket);
            jo.put("signature", signature);
            returnObject.setResult(jo.toJSONString());
            return returnObject;
        }
        public static void main(HttpServletRequest request,
                HttpServletResponse response) throws IOException, URISyntaxException {
            
//                UtilOAuthWx.OAuthlogin(request, response);
            ReturnObject<String > s = UtilOAuthWx.getWxConfig();
            System.out.println(s);
        }
}
