package com.ocean.stock.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocean.stock.dao.UserMapper;
import com.ocean.stock.entity.User;
import com.ocean.stock.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    public int addUser(User user){
        
        return userMapper.insert(user);
    }
    //TODO 软删除 只做更新
//    public int deleteUserById(User user){
//        
//        return userMapper.insert(user);
//    }
    
    /**
    * @Description update user  by id  
    * @param user
    * @return
    * @author yanghaiyang   
    * @date 2016年12月20日 上午12:06:44
     */
    public int updateUser(User user){
        
        return userMapper.updateByPrimaryKeySelective(user);
    }
    
}
