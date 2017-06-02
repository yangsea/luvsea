package com.luvsea.blog.common.shiro;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.servlet.ShiroHttpSession;

public class Shiro extends ShiroHttpSession {

    public Shiro(Session session, HttpServletRequest currentRequest, ServletContext servletContext) {
        super(session, currentRequest, servletContext);
        // TODO Auto-generated constructor stub
    }

}
