package com.ocean.main.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocean.main.dao.UserDao;
import com.ocean.main.entity.Test;
import com.ocean.main.entity.User;
import com.ocean.main.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
//
    @Autowired
    private UserDao userDao;
    
    public List<User> findUserList() {
        
        return this.userDao.findUserList();
//        return new ArrayList<User>();
        
    }

    @Transactional(rollbackFor=Exception.class)
    public int testAdd(Test test) {
        
        int flag = this.userDao.testAdd(test);
        
//        String a = null ; a.toString();
        return flag;
    }

    public List<HashMap<Object, Object>> findListByProtocal() {
        
        return this.userDao.findListByProtocal();
    }

    public User findUserBySelected(User user) {

        return this.userDao.findUserBySelected(user);
    }
    
}
