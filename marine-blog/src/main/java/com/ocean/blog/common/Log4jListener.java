package com.ocean.blog.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jListener implements ServletContextListener {

    public static final String log4jDirkey = "log4jdirs";
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.getProperties().remove(log4jDirkey);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        String log4jDir = sce.getServletContext().getRealPath("/");
        System.out.println("@@@@@@@@@@@@@@@@@@############"+log4jDir);
        
//        log4jDir="E:\\ocean\\dooriya\\src\\main\\webapp";
        System.setProperty(log4jDirkey,log4jDir);
        System.out.println(System.getProperty(log4jDirkey));
        System.out.println();
    }
}
