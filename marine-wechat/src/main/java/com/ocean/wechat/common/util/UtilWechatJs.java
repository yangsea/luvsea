package com.luvsea.wechat.common.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import com.alibaba.fastjson.JSONObject;
import com.ocean.common.basic.UtilString;
import com.ocean.common.http.UtilHttpClient;
import com.ocean.common.returnobject.ReturnObject;

public class UtilWechatJs {
    
    /**
     * @Description 获取微信js签名
     * @author yanghaiyang
     * @date 2016年12月26日 下午5:12:25
     */
//    public static ReturnObject<String>   getJsSignature(final String url
//            ,final String accessToken, final String jsApiTicket, final ServletContext servletContext){
//        
//        final ReturnObject<String> returnObject = new ReturnObject<String>();
//        if(UtilString.isEmpty(url)){
//            returnObject.setMsg("url is null!");
//            returnObject.setSuccess(false);
//        }else{
//            //fetch jsapiticket
//            if(UtilString.isEmpty(jsApiTicket)){
//                //如果為空殺掉之前的線程并重啟
////                String respJson = getJsApiTicket(accessToken);
////                final Integer c = 0;
////               final Thread th =  new  Thread() {
////                    @Override
////                    public void run() {
//////                        String jsApiTicketStr = getJsApiTicket(accessToken);
////                        String jsApiTicketStr = "";
////                        if(UtilString.isEmpty(jsApiTicketStr)){
//////                            returnObject.setMsg("japi ticket fetch fail!");
//////                            returnObject.setSuccess(false);
////                            this.interrupt();
////                            getJsSignature( url  ,accessToken, jsApiTicket, servletContext);
////                        }else{
////                            // put servletcontext 
////                            servletContext.setAttribute("jsApiTicket", jsApiTicketStr);
////                            JSONObject jot = JSONObject.parseObject(jsApiTicketStr);
////                            String ticket = jot.getString("ticket");
////                            if(UtilString.isEmpty(ticket)){
////                                returnObject.setMsg("japi ticket fetch fail!");
////                                returnObject.setSuccess(false);
////                            }else{
////                                try {
////                                    Map<String, String> map = UtilWechatJsSign.sign(ticket, URLEncoder.encode(url,"utf-8"));
////                                    map.put("appId", UtilProperties.getProWxByKey("wx.appId"));
////                                    JSON finalJ = JSONSerializer.toJSON(map);
////                                    returnObject.setResult(finalJ.toString());
////                                } catch (IOException e) {
////                                    returnObject.setMsg("japi ticket fetch fail!");
////                                    returnObject.setSuccess(false);
////                                    e.printStackTrace();
////                                }
////                            }
////                        }
////                        System.out.println("thread is start===========执行完毕========result= "+jsApiTicketStr);
////                    }
////               }.start();  
////               ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();  
////               // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
//////           service.scheduleAtFixedRate(new UtilWechatJs().new JsTicketThread(), 1, 2, TimeUnit.SECONDS);  
////               System.out.println("线程是否存活++++++++======"+th.isAlive());
////               service.scheduleAtFixedRate(th, 2, 4, TimeUnit.SECONDS);  
////               System.out.println("線程已開啟");
//            }
//        }
//        //待解决问题，系统初始化时，或者是利用系统启动时候启动这个线程，或者是通过用户触发，但是利用线程组来维护线程的生存与消亡
//        return returnObject;
//    }

    static String getJsApiTicket(String accessToken){
        
        JSONObject jo = new JSONObject();
        try {
//           String accessTokenStr = UtilAccessToken.getAccessTokenByThread(accessToken);
           //accesstoken不能随便获取，可以使用redis配合，后者是session
           JSONObject jot = JSONObject.parseObject(accessToken);
           accessToken = jot.getString("access_token");
           jo.put("access_token", accessToken);
           jo.put("type", "jsapi");
//           https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
           String response = UtilHttpClient.getGetResponse(jo.toJSONString(), 
                   "https://api.weixin.qq.com/cgi-bin/ticket/getticket");
           return response;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
    
public static String getJsApiTicketByRedis(){
    
    return "";
}
//String accesstoken;
class JsTicketThread extends Thread {
//    @Override
//    public void run() {
//        jsApiTicketStr = getJsApiTicket(accessTokenGlobal);
//        System.out.println("thread is start==================== ");
//    }
}

public static void main(String[] args) {
    
//    String api  =getJsApiTicket("fG49guWf66dv8iiRbjB5dJ4EgcOjCu74t7F1GseQ7tJc6kGZJoJZmXkcqoA-fFU1bJDuxrX9qrZ20P0vtAyOtVIwXtJEkBUwMn5GLfQH7-KkqVCj_Lt5_20OczcMiysXWPNcAJABUS");
//    System.out.println(api);
//    jt.run();
//    Timer timer = new Timer();  
//    long delay = 0;  
//    long intevalPeriod = 1 * 1000;  
//    // schedules the task to be run in an interval  
//    timer.scheduleAtFixedRate(threadTest(), delay, intevalPeriod);  
    ScheduledExecutorService service = Executors  
            .newSingleThreadScheduledExecutor();  
    // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
    service.scheduleAtFixedRate(new UtilWechatJs().new JsTicketThread(), 1, 2, TimeUnit.SECONDS);  
    System.out.println("跳過線程");
}
public static String threadTest(){
    
    JsTicketThread jt = new UtilWechatJs().new JsTicketThread();
//    jt.setDaemon(true);
    jt.start();
    while(true){
        try {
            Thread.sleep(3000);
            System.out.println("開始睡眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        jt.interrupt();
        
    }
}

//public static String getJsApiTicketByThread(){
//
//  final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//          .getRequestAttributes()).getRequest();
//  String jsapiTicket = String.valueOf(request.getSession().getAttribute("jsapiTicket"));
//  if (UtilString.isNull(jsapiTicket)) {
//      new Thread() {
//          public void run() {
//              while (true) {
//                  String response = getJsApiTicket();
//                  if (UtilString.isEmpty(response)) {
//                      getJsApiTicketByThread();
//                  } else {
//                      // 放入数据库，或者是redis，或者是session
//                      request.getSession().setAttribute("jsapiTicket", response);
//                      // 两个小时后再刷新
//                      try {
//                          Thread.sleep(10000);
//                      } catch (InterruptedException e) {
//                          e.printStackTrace();
//                      }
//                  }
//              }
//          };
//      }.start();
//      return String.valueOf(request.getSession().getAttribute("jsapiTicket"));
//  }else{
//      return jsapiTicket;
//  }
//}

    /**
     * @Description 获取微信js签名
     * @author yanghaiyang
     * @date 2016年12月26日 下午5:12:25
     */
    public static ReturnObject<String>   getJsSignature(String url,String jsApiTicket){
        
        final ReturnObject<String> returnObject = new ReturnObject<String>();
        if(UtilString.isEmpty(url)){
            returnObject.setMsg("url is null!");
            returnObject.setSuccess(false);
        }else{
            //fetch jsapiticket
            if(UtilString.isEmpty(jsApiTicket)){
                returnObject.setMsg("japi ticket fetch fail!");
                returnObject.setSuccess(false);
            }else{
                // put servletcontext 
                JSONObject jot = JSONObject.parseObject(jsApiTicket);
                String ticket = jot.getString("ticket");
                if(UtilString.isEmpty(ticket)){
                    returnObject.setMsg("japi ticket fetch fail!");
                    returnObject.setSuccess(false);
                }else{
                    try {
//                        Map<String, String> map = UtilWechatJsSign.sign(ticket, URLEncoder.encode(url,"utf-8"));
                        
                        Map<String, String> map = UtilWechatJsSign.sign(ticket, url);
                        map.put("appId", UtilProperties.getProWxByKey("wx.appId"));
                        JSON finalJ = JSONSerializer.toJSON(map);
                        returnObject.setResult(finalJ.toString());
                    } catch (IOException e) {
                        returnObject.setMsg("japi ticket fetch fail!");
                        returnObject.setSuccess(false);
                        e.printStackTrace();
                    }
                }
            }
        }
        //待解决问题，系统初始化时，或者是利用系统启动时候启动这个线程，或者是通过用户触发，但是利用线程组来维护线程的生存与消亡
        return returnObject;
    }
}
