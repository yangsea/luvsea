package com.luvsea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.luvsea.common.UserAbstract;
import com.luvsea.dao.userDao;

@Service
@Scope("prototype")
public class UserService extends UserAbstract {
    
    @Autowired
    private userDao userDao;
    
    public String getUser(){
        
        String str = userDao.getUser();
        String str1  = super.getUserAbs();
        return "this getuser service"+str+str1;
    }
    @Override
    public String getUserAbs() {
        // TODO Auto-generated method stub
        return super.getUserAbs();
    }
}
