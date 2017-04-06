/**
 * 
 */
package com.ocean.wechat.common.token.server;



/**
 * accessToken中控服务器
 * tokenServer是为了抽象统一返回类型
 * @author ChengNing
 * @date   2015年1月9日
 */
public interface TokenServer {
	
	public String token();
}
