package com.luvsea.wechat.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.luvsea.common.http.UtilHttpClient;
import com.luvsea.common.basic.UtilString;

public class UtilAccessToken {
    
    private static int reptimes =1;

    private static Logger log = LoggerFactory.getLogger(UtilAccessToken.class);
    
    /** get access_tocken */
    private static String getAccessToken() {

        JSONObject jo = new JSONObject();
        try {
            jo.put("grant_type", "client_credential");
            jo.put("appid", UtilProperties.getProWxByKey("wx.appId"));
            jo.put("secret", UtilProperties.getProWxByKey("wx.secret"));
            String response = UtilHttpClient.getGetResponse(jo.toJSONString(),
                    "https://api.weixin.qq.com/cgi-bin/token");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  token生成器，这种方法的弊端为：
     *  当accesstoken失效后再手动获取的时候，无法重新触发，
     *  因为失效后若手动去触发因子（最小单位获取器）执行后无法再与本方法关联起来，会造成过早刷新
     *  这就形成了非单例获取token，造成服务器各自刷新很容易超过限制
     *  因此生成环境中一定要放弃此方法，采用代理中控服务器实现单例安全获取
    * @Description  
    * @param sce
    * @author yanghaiyang   
    * @date 2017年4月5日 下午9:04:30
     */
    @Deprecated
    public static void getAccessTokenByThread(final ServletContextEvent sce) {
        
            new Thread() {
                public void run() {
                    while (true) {
                        log.debug("======******accessToken获取开始******=====");
                        String response = getAccessToken();
                        log.debug("======******accessToken获取结束*****====="+response);
//                        sce.getServletContext().setAttribute("accessToken", response);
                        if (UtilString.isEmpty(response)) {
                            this.interrupt(); //中断请求继续执行下面代码
                            //重试机会
                            if (reptimes<=2) {
                                reptimes+=1;
                                getAccessTokenByThread(sce);
                            }else{
                                return;
                            }
                        } else {
                            reptimes = 1;
                            // 把获取到的放在数据库中，或者是redis中，定时刷新（使用线程沉睡）
                            // 放入数据库，或者是redis，或者是session
                            //request.getSession().setAttribute("accessToken", response);
                            sce.getServletContext().setAttribute("accessToken", response);
                            // 两个小时后再刷新
                            try {
                                //fetch jsapiticket
                                log.debug("======*****JsApiTicketConsole获取开始******====="
                                        +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                                String jsResponse = UtilWechatJs.getJsApiTicket(response);
                                if(UtilString.isEmpty(jsResponse)){
                                    log.debug("jstoken获取失败，即将从新获取.....");
                                    for (int i = 0; i < reptimes; i++) {
                                        jsResponse = UtilWechatJs.getJsApiTicket(response);
                                        if(!UtilString.isEmpty(jsResponse)){
                                            break;
                                        }
                                    }
                                }
                                if(!UtilString.isEmpty(jsResponse)){
                                    sce.getServletContext().setAttribute("jsApiTicket", jsResponse);
                                }
                                log.debug("======*****JsApiTicketConsole获取结束******====="+jsResponse);
                                Thread.sleep(7000000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }.start();
    }
    
//    public static String getAccessTokenByRedis(){
//        String accessToken = UtilsJedis.get("accessTokenGD");
//        if(UtilString.isEmpty(accessToken)){
//            String res = getAccessToken();
//            UtilsJedis.set("", res, 10000);
//        }
//        return "";
//    }

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
