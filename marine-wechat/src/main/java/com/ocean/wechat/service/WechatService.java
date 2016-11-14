package com.ocean.wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WechatService {
    
    public void authUnify(HttpServletRequest request, HttpServletResponse response);
    
    public String getOpenId(HttpServletRequest request, HttpServletResponse response);
    
    public String getUser(HttpServletRequest request, HttpServletResponse response);
}
