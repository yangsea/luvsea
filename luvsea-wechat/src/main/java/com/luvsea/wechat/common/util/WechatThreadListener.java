package com.luvsea.wechat.common.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WechatThreadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("=============start wechat listener");
        UtilAccessToken.getAccessTokenByThread(sce);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
