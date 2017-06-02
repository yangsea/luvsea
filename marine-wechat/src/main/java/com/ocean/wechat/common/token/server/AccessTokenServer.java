package com.ocean.wechat.common.token.server;

import com.ocean.wechat.common.util.Config;


/**
 * 适配器，对外接入口
 * @author ChengNing
 * @date   2015年1月30日
 */
public class AccessTokenServer extends AbsServer implements TokenServer {
	
	public String token(){
	    //super执行AbsServer()的构造方法
		return super.token();
	}

	@Override
	protected String getCustomerServerClass() {
		return Config.instance().getAccessTokenServer();
	}

	@Override
	public IServer defaultServer() {
	    //获取单例服务对象，不能new对象来保证获取对象唯一性
		return AccessTokenMemServer.instance();
	}

}
