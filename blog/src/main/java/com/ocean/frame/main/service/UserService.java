package com.ocean.frame.main.service;

import java.util.HashMap;
import java.util.List;

import com.ocean.frame.main.entity.Test;
import com.ocean.frame.main.entity.User;

public interface UserService {

    public List<User> findUserList();
    
    public int testAdd (Test test);
    
    public List<HashMap<Object, Object>> findListByProtocal();
    
    public User findUserBySelected(User user);
}
