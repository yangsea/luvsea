package com.ocean.wechat.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.http.UtilHttpClient;
import com.ocean.common.returnobject.ReturnObject;

public class UtilWechat {
    
    /**
     * @Description  认证跳转 必须暴露成接口，否则没办法用httpclient方式来调用而达到抓取json的目的
     * @author yanghaiyang   
      * @throws UnsupportedEncodingException 
     * @date 2016年11月9日 下午5:01:39
      */
     public static  void authRedirect(HttpServletResponse response,
             String appId,String secret, String redirectUrl) 
             throws UnsupportedEncodingException{
         
         //rdirecturl to...
         //跳转后转到回调地址 exm ocean.iask.in 
         //比如说这里的getopenid接口 ，获取openid后对接业务
         //记得openid要放到session中，作为已登录标识，避免拦截器后续处理麻烦，
         //可以使用authunify统一放入，然后再重定向到目标页面，使用params组织动态放入页面与参数
         //startconfig
         String serviceUrl = URLEncoder.encode( redirectUrl , "utf-8");
         //如果session未空或者取消授权，重定向到授权页面
//         if (( session.getAttribute("uid") == null)) {
             //--最终审议，重新点击必须重新授权
             StringBuilder oauth_url = new StringBuilder();
             oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
             oauth_url.append("appid=").append(appId);
             oauth_url.append("&redirect_uri=").append(serviceUrl);
             oauth_url.append("&response_type=code");
             oauth_url.append("&scope=snsapi_userinfo");
             String redirectUrlCustom = ""; //待使用
             oauth_url.append("&state="+redirectUrlCustom+"#wechat_redirect");
             try {
                 response.sendRedirect(oauth_url.toString());
                 //或者直接在这里用httpclient进行请求
             } catch (IOException e) {
                 e.printStackTrace();
             }
     }

     /**
      * 通过code换取网页授权access_token
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
         String response  = UtilHttpClient.getPostResponse(params, apiUrl);
         return JSON.parseObject(response);
     }
     
     //获取用户信息
     public static JSONObject getUserInfo(String accessToken, String openid) 
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

     public static String getOpenId(String params) {

         //get openid by code
         boolean isValidCode = true;
         // first , to auth
         String response = UtilHttpClient.getPostResponse(params,"xxx/auth/toAuth");
         JSONObject jsonObject = JSONObject.parseObject(response);
         String code = jsonObject.getString("code");
//         String code = request.getParameter("code");
       //检查是否已验证或者验证是否通过
         if (code == null || code.equals("authdeny")) {
             isValidCode = false;
         }
       //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
         try {
             if (isValidCode) {
                 JSONObject jo4AT = JSONObject.parseObject(params);
                 String appId = jo4AT.getString("appId");
                 String secret = jo4AT.getString("secret");
                  JSONObject obj = getAccessToken(appId,secret, code);
                 String openid = obj.getString("openid");
                 return openid;
             }
         } catch (IOException | URISyntaxException e) {
                 e.printStackTrace();
          }
         return null;
     }
     
     public static ReturnObject<String> auth(HttpServletRequest request,HttpServletResponse response){
         
         ReturnObject<String> ret = new ReturnObject<>();
         try {
             String redirectAuthURL = request.getParameter("redirectAuthURL");        
             if(UtilString.isEmpty(redirectAuthURL)){
                 ret.setMsg("redirectAuthURL不能为空！");
                 ret.setSuccess(false);
             }else{
               //开始认证
                //解码url
//                 String deURL = URLDecoder.decode(redirectAuthURL,"utf-8");
                 String appId = String.valueOf(request.getAttribute("appId"));
                 //.......
                 JSONObject jo4para = new JSONObject();
                 jo4para.put("appId", "");
                 jo4para.put("secret", "");
                 //...........
                 String openId = getOpenId(jo4para.toJSONString());
                 if(UtilString.isEmpty(openId)){
                     ret.setMsg("服务器异常！");
                     ret.setSuccess(false);
                 }
                 redirectAuthURL+=(redirectAuthURL.indexOf("?")>0?"&":"?")+"openid="+openId;
                 response.sendRedirect(redirectAuthURL);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return ret;
     }
}
