/**
 * 
 */
package com.ocean.wechat.common.token.server;

import com.ocean.wechat.common.util.Config;


/**
 * 适配器
 * @author ChengNing
 * @date   2015年1月30日
 */
public class AccessTokenServer extends AbsServer implements TokenServer {
	

	/**
	 * 
	 */
	public String token(){
		return super.token();
	}

	@Override
	protected String getCustomerServerClass() {
		return Config.instance().getAccessTokenServer();
	}

	@Override
	public IServer defaultServer() {
		return AccessTokenMemServer.instance();
	}

}
