package com.luvsea.wechat.common.token;

import org.apache.log4j.Logger;


/**
 * 微信ticket操作类
 * ticket和token的逻辑在腾讯是差不多的，所以继承抽象类token
 * @author ChengNing
 * @date   2015年1月29日
 */
public class Ticket extends Token {

	private static Logger logger = Logger.getLogger(Ticket.class);
	
	private static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
	private static final String TICKET_NAME = "ticket";
	private static final String EXPIRESIN_NAME = "expires_in";
	
	private String type;
	
	public Ticket(TicketType ticketType){
		super();
		this.type = ticketType.name();
	}

	@Override
	protected String accessTokenUrl() {
		String access_token = TokenProxy.accessToken();
		String url = TICKET_URL + "access_token=" + access_token + "&type=" + this.type;
		logger.info("获取ticket,ticket类型" + this.type);
		return url;
	}
	
	@Override
	protected String tokenName() {
		return TICKET_NAME;
	}

	@Override
	protected String expiresInName() {
		return EXPIRESIN_NAME;
	}


}
