package com.luvsea.common.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class UtilHttpClient {
    
    private static String encode = "UTF-8";
//    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UtilHttpClient.class);
    public static String getPostResponse(String params,String host) {

        CloseableHttpClient client = HttpClientManager.getHttpClient();
        HttpPost post = new HttpPost(host);
        try {
            post.setEntity(new UrlEncodedFormEntity(getParam(params),encode));
            HttpResponse httpResponse = client.execute(post);  
            HttpEntity entity = httpResponse.getEntity();  
            if (entity != null) {  
                String entitys = EntityUtils.toString(entity,encode);
//                logger.info(entitys);
                entity.getContent().close();//释放
                return entitys;
            } 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(client!=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }  
        }
        return null;
    }
    
public static String getGetResponse(String params,String host){
    
        CloseableHttpClient client = HttpClientManager.getHttpClient();
        HttpGet get = new HttpGet(host);
        try {
            String paramss = EntityUtils.toString(new UrlEncodedFormEntity(getParam(params)),encode);
            get.setURI(new URI(get.getURI().toString()+"?"+ paramss));
            HttpResponse httpResponse = client.execute(get);  
            HttpEntity entity = httpResponse.getEntity();  
            if (entity != null) {  
                String entitys = EntityUtils.toString(entity,encode);
//                logger.info(entitys);
                entity.getContent().close();//释放
                return entitys;
            } 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }catch (IOException  e) {
            e.printStackTrace();
        } catch(URISyntaxException u){
            u.printStackTrace();  
        }finally{
            if(client!=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }  
        }
        return null;
    }
    
    //用于短信
    public static String getPostResponseBySms(String params,String host){
        
        String smsEnCode = "GBK";
        CloseableHttpClient client = HttpClientManager.getHttpClient();
        HttpPost post = new HttpPost(host);
        try {
            post.setEntity(new UrlEncodedFormEntity(getParam(params),smsEnCode));  
            HttpResponse httpResponse = client.execute(post);  
            HttpEntity entity = httpResponse.getEntity();  
            if (entity != null) {  
                String entitys = EntityUtils.toString(entity,smsEnCode);
//                logger.info(entitys);
                entity.getContent().close();
                return entitys;
            } 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }catch (IOException  e) {
            e.printStackTrace();
        } finally{
            if(client!=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }  
        }
        return null;
    }

    private static List<NameValuePair> getParam(String params){
        
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
        if(null!=params&&!"".equals(params)){
            JSONObject jsonObject = JSONObject.parseObject(params);
            @SuppressWarnings("rawtypes")
            Map  map = (Map)jsonObject;
            for( @SuppressWarnings("rawtypes")
            Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)  
            {  
                @SuppressWarnings("unchecked")
                Entry<String, String> entry = (Entry<String, String>)iterator.next();  
                 nameValuePairs.add(new BasicNameValuePair(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
            }
        }
        return nameValuePairs;
    }
    
    public static void main(String[] args) {
        
        String base = "12";   //1,或者2随便取一个
        Random random = new Random();   
        int number = random.nextInt(base.length());   
        char a = base.charAt(number);
          String params = "{\"eggs\":"+a+"}";
      String jsonStr = UtilHttpClient.getPostResponse(params, "http://luvsea.iask.in/blog/article/getEggs");
        System.out.println(jsonStr);
    }

}
