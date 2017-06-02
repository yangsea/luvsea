package com.luvsea.wechat.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luvsea.common.basic.UtilString;
import com.luvsea.common.returnobject.ReturnObject;
import com.luvsea.wechat.common.oauth.OAuthException;
import com.luvsea.wechat.common.oauth.OAuthManager;
import com.luvsea.wechat.common.oauth.OAuthToken;
import com.luvsea.wechat.common.oauth.protocol.get_access_token.GetAccessTokenRequest;
import com.luvsea.wechat.common.oauth.protocol.get_access_token.GetAccessTokenResponse;
import com.luvsea.wechat.common.util.Config;
import com.luvsea.wechat.common.util.UtilUserManager;

@Controller
@RequestMapping("user")
public class UserController {
    

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    /** 登录授权 */
    @RequestMapping("login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) 
            throws OAuthException {

        try {
            String code = request.getParameter("code");
            if (UtilString.isEmpty(code)) {
                String urlByOpenId = request.getParameter("backCallUrl");
                StringBuffer sb = new StringBuffer();
                @SuppressWarnings("unchecked")
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String string = (String) params.nextElement();
                    // 不是微信服务器地址，并且不是回调服务器地址
                    if (!"backCallUrl".equals(string)) {
                        String values = request.getParameter(string);
                        sb.append((UtilString.isEmpty(sb.toString()) ? "" : "&") + string + "="
                                + URLEncoder.encode(values, "utf-8"));
                    }
                }
                // state 中的&字符需要编码，否则会从&处断开
                if(sb.length()>0){
                    urlByOpenId += (urlByOpenId.indexOf("?") == -1 ? "?" : "&") + sb.toString();
                }
                String hostUrl = Config.instance().getUrl();
                // backSelfUrl 为用户服务器地址
                String outhURL = OAuthManager.generateRedirectURI(hostUrl + "/user/login?backSelfUrl=" + urlByOpenId,
                        "snsapi_userinfo", null);
                response.sendRedirect(outhURL);
            } else {
                GetAccessTokenResponse getAccessTokenResponse = OAuthManager.getAccessToken(new GetAccessTokenRequest(
                        code));
                OAuthToken.ACCESS_TOKEN = getAccessTokenResponse.getAccess_token();
                String openId = getAccessTokenResponse.getOpenid();
                String urlByOpenId = request.getParameter("backSelfUrl");
                StringBuffer sb = new StringBuffer();
                sb.append("openId=" + openId);
                @SuppressWarnings("unchecked")
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String string = (String) params.nextElement();
                    // 不是微信服务器地址，并且不是回调服务器地址
                    if (!"backSelfUrl".equals(string)&&!"code".equals(string)) {
                        String values = request.getParameter(string);
                        if("abcStr".equals(string)){
                            String encryptKey =  DigestUtils.md5Hex(values+"jxmallwechatsalt");
                            sb.append((UtilString.isNull(sb.toString()) ? "" : "&") + "encryptKey="
                                    + URLEncoder.encode(encryptKey, "utf-8"));
                        }
                        sb.append((UtilString.isNull(sb.toString()) ? "" : "&") + string + "="
                                + URLEncoder.encode(values, "utf-8"));
                    }
                    //redirecturl的参数在外部自己组装
                }
                urlByOpenId += (urlByOpenId.indexOf("?") == -1 ? "?" : "&") + sb.toString();
                response.sendRedirect(urlByOpenId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.debug("授权异常");
        }
    }

    /**
     * 获取微信用户信息
     */
    @RequestMapping("getUser")
    @ResponseBody
    public ReturnObject<String> getUser(String openId) {

        ReturnObject<String> returnObject = new ReturnObject<>();
        try {
            String response = UtilUserManager.getUserInfo(openId);
            returnObject.setResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setSuccess(false);
            returnObject.setMsg("获取微信用户信息失败");
        }
        return returnObject;
    }

    // @RequestMapping("getJsSign")
    // @ResponseBody
    // public ReturnObject<String> getJsSign(HttpServletRequest request){
    //
    // ReturnObject<String> returnObject = new ReturnObject<String>();
    // String url = request.getParameter("url");
    // String accessToken =
    // String.valueOf(request.getSession().getServletContext().getAttribute("accessToken"));
    // String jsApiTicket =
    // String.valueOf(request.getSession().getServletContext().getAttribute("jsApiTicket"));
    // // returnObject =
    // UtilWechatJs.getJsSignature(url,accessToken,jsApiTicket,request.getSession().getServletContext());
    // return returnObject;
    // }
    //
    // /**
    // * @Description 获取config注入信息
    // * @param request
    // * @return
    // * @author yanghaiyang
    // * @date 2016年12月27日 上午9:47:35
    // */
    // @RequestMapping("getConfigJs")
    // @ResponseBody
    // public ReturnObject<String> getConfig(HttpServletRequest request){
    //
    // ReturnObject<String> returnObject = new ReturnObject<String>();
    // try {
    // String url = request.getParameter("url");
    // if(UtilString.isEmpty(url)){
    // returnObject.setMsg("url is not null !");
    // returnObject.setSuccess(false);
    // }else{
    // // String accessToken = String.valueOf(request.getSession()
    // // .getServletContext().getAttribute("accessToken"));
    // //jsapiticket
    // String jsApiTicket = String.valueOf(request.getSession()
    // .getServletContext().getAttribute("jsApiTicket"));
    // returnObject = UtilWechatJs.getJsSignature(url ,jsApiTicket);
    // log.debug(returnObject.toString());
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // returnObject.setMsg("程序出错，"+e.getMessage());
    // returnObject.setSuccess(false);
    // }
    // return returnObject;
    // }
}
