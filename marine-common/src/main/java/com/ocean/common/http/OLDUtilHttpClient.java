package com.ocean.common.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

public class OLDUtilHttpClient {
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(OLDUtilHttpClient.class);
    public static String getPostResponse(String params,String host) throws ClientProtocolException, IOException{
        
        HttpClientBuilder a = HttpClientBuilder.create();
        HttpClient client = a.build();
        HttpPost post = new HttpPost(host);
        post.setEntity(new UrlEncodedFormEntity(getParam(params),"GBK"));  
        HttpResponse httpResponse = client.execute(post);  
//        post.getParams()
        HttpEntity entity = httpResponse.getEntity();  
        System.out.println("status:" + httpResponse.getStatusLine());  
        if (entity != null) {  
            System.out.println("contentEncoding:" + entity.getContentEncoding());  
            String entitys = EntityUtils.toString(entity, "GBK");
            logger.debug(entitys);
            System.out.println("response content:"+entitys);
//            closeableHttpClient.close();
            return entitys;
        } 
        return null;
    }
    
public static String getGetResponse(String params,String host) throws ClientProtocolException, IOException, URISyntaxException{
        
        HttpClientBuilder a = HttpClientBuilder.create();
        HttpClient client = a.build();
        HttpGet get = new HttpGet(host);
        get.addHeader("Content-type", "text/html;charset=UTF-8");
        String paramss = EntityUtils.toString(new UrlEncodedFormEntity(getParam(params)));
        get.setURI(new URI(get.getURI().toString() + "?" + paramss));
        HttpResponse httpResponse = client.execute(get);  
        HttpEntity entity = httpResponse.getEntity();  
        System.out.println("status:" + httpResponse.getStatusLine());  
        if (entity != null) {  
            System.out.println("contentEncoding:" + entity.getContentEncoding());  
            String entitys = EntityUtils.toString(entity);
            System.out.println("response content:"+entitys);
            logger.debug(entitys);
//           entity.consumeContent();
            return entitys;
        } 
        return null;
    }
    
    private static List<NameValuePair> getParam(String params){
        
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
        JSONObject jsonObject = JSONObject.parseObject(params);
        Map  map = (Map)jsonObject;
        for( Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)  
        {  
            Entry<String, String> entry = (Entry<String, String>)iterator.next();  
             nameValuePairs.add(new BasicNameValuePair(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        }
        return nameValuePairs;
    }

}
