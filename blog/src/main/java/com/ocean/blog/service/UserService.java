package com.ocean.blog.service;

import java.util.HashMap;
import java.util.List;

import com.ocean.blog.entity.Test;
import com.ocean.blog.entity.User;

public interface UserService {

    public List<User> findUserList();
    
    public int testAdd (Test test);
    
    public List<HashMap<Object, Object>> findListByProtocal();
    
    public User findUserBySelected(User user);
}
