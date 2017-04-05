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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.encrypt.UtilSha14Wx;
import com.ocean.common.entity.wx.UserWx;
import com.ocean.common.enumeration.EnumHost;
import com.ocean.common.http.UtilHttpClient;
import com.ocean.common.returnobject.ReturnObject;

public class UtilOAuthWx {

        private  String appId;
        private  String secret;
        private  String redirectUrl;
        private  String redirectUrlCustom;

        public void OAuthLogin(HttpServletRequest request,
                HttpServletResponse response) throws IOException {
            
            String serviceUrl = URLEncoder.encode( redirectUrl , "utf-8");
            //如果session未空或者取消授权，重定向到授权页面
//            if (( session.getAttribute("uid") == null)) {
                //--最终审议，重新点击必须重新授权
                StringBuilder oauth_url = new StringBuilder();
                oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
                oauth_url.append("appid=").append(appId);
                oauth_url.append("&redirect_uri=").append(serviceUrl);
                oauth_url.append("&response_type=code");
                oauth_url.append("&scope=snsapi_userinfo");
                oauth_url.append("&state="+redirectUrlCustom+"#wechat_redirect");
                response.sendRedirect(oauth_url.toString());
                return;
        }
        
        //获取用户信息
        public String getOpenId(HttpServletRequest request,
                HttpServletResponse response) throws ClientProtocolException, IOException, URISyntaxException{
            
            HttpSession session = request.getSession();
            boolean isValidCode = true;
            String code = request.getParameter("code");
            String state = request.getParameter("state");
          //检查是否已验证或者验证是否通过
            if (code == null || code.equals("authdeny")) {
                isValidCode = false;
            }
          //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
            if (isValidCode && session.getAttribute("openId") == null) {
                    JSONObject obj = getAccessToken(appId,secret, code);
                    String token = obj.getString("access_token");
                    String openid = obj.getString("openid");
                    request.getSession().setAttribute("openId", openid);
                    //根据openid查询数据库中数据，，写在各自项目中
                    JSONObject user = getUserInfo(token, openid);
//                    UserWx userWx = JSONObject.toJavaObject(user, UserWx.class);
                    UserWx userWx = new UserWx();
                    userWx.setOpenid(String.valueOf(user.get("openid")));
                    userWx.setNickname(String.valueOf(user.get("nickname")));
                    if(null!=user.get(user.get("sex"))&&!"".equals(String.valueOf(user.get("sex")))){
                        userWx.setSex(Integer.valueOf(String.valueOf(user.get("sex"))));
                    }
                    userWx.setProvince(String.valueOf(user.get("province")));
                    userWx.setCity(String.valueOf(user.get("city")));
                    userWx.setCountry(String.valueOf(user.get("country")));
                    userWx.setHeadimgurl(String.valueOf(user.get("headimgurl")));
                    session.setAttribute("userWx", userWx);
                    session.setAttribute("state", state);
                    return openid;
            }else{
                String openId = String.valueOf(request.getSession().getAttribute("openId"));
                return openId;
            }
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
        public JSONObject getUserInfo(String accessToken, String openid) throws ClientProtocolException, IOException, URISyntaxException {

            String host = "https://api.weixin.qq.com/sns/userinfo?";
            JSONObject jo = new JSONObject();
            jo.put("access_token", accessToken);
            jo.put("openid", openid);
            jo.put("lang", "zh_CN");
            String params  = JSON.toJSONString(jo);
            String response  = UtilHttpClient.getGetResponse(params, host);
            return JSON.parseObject(response);
        }

        /**
        * @Description 获取普通access_token  //用于js
        * @author yanghaiyang   
         * @throws URISyntaxException 
         * @throws IOException 
         * @throws ClientProtocolException 
        * @date 2016年9月5日 下午6:01:19
         */
        public String getAccessToken() throws ClientProtocolException, IOException, URISyntaxException{
            
            JSONObject jo = new JSONObject();
            jo.put("grant_type","client_credential");
            jo.put("appid",appId);
            jo.put("secret", secret);
            String response = UtilHttpClient.getGetResponse(JSON.toJSONString(jo), EnumHost.accessTokenHost.getValue());
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
        public String getTicket() throws ClientProtocolException, IOException, URISyntaxException{
            
            JSONObject jo = new JSONObject();
            jo.put("access_token", getAccessToken());
            String response = UtilHttpClient.getPostResponse(JSON.toJSONString(jo), EnumHost.ticketHost.getValue());
            JSONObject retJo = JSONObject.parseObject(response);
            String ticket  = String.valueOf(retJo.get("ticket"));
            return ticket;
        }
        
        //js签名
        public ReturnObject<String> getWxConfig() throws ClientProtocolException, IOException, URISyntaxException{
            
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
            jo.put("url","http://checkin.shahb.net");
            jo.put("ticket", ticket);
            jo.put("signature", signature);
            returnObject.setResult(jo.toJSONString());
            return returnObject;
        }
        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }
        public void setAppId(String appId) {
            this.appId = appId;
        }
        public void setSecret(String secret) {
            this.secret = secret;
        }
        public void setRedirectUrlCustom(String redirectUrlCustom) {
            this.redirectUrlCustom = redirectUrlCustom;
        }

        public  void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
            
//            JSONObject jo = UtilOAuthWx.getAccessToken(EnumWx.appIdPointSmall.getValue(), EnumWx.secretPointSmall.getValue(), "041lgEOK05Tz1k2jYWLK0HQDOK0lgEOy");
//            System.out.println(jo);
        }
}
