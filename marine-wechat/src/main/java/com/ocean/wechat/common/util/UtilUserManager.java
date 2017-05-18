package com.ocean.wechat.common.util;

import org.apache.log4j.Logger;

import com.ocean.common.http.UtilHttpClient;
import com.ocean.wechat.common.token.TokenProxy;
/**
 * 用户管理
 * @author Zhangxs
 * @version 2015-7-5
 */
public class UtilUserManager {

	static Logger logger = Logger.getLogger(UtilUserManager.class);
	//获取用户基本信息
	private static final String USER_INFO_GET_URL="https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN&access_token=";
	
	/**
	 * 获取用户基本信息
	 * @param openid 普通用户的标识，对当前公众号唯一
	 * @return
	 */
	public static String getUserInfo(String openId){
	    
		String url = USER_INFO_GET_URL+TokenProxy.accessToken()+"&openid="+openId;
		String resultStr = UtilHttpClient.getGetResponse(null, url);
		if(resultStr.contains("access_token is invalid")){
		    logger.info("return data:"+TokenProxy.accessToken()+resultStr);
        }else{
            logger.info("return data: "+resultStr);
        }
		return resultStr;
	}
	
}
