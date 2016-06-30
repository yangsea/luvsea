package com.ocean.main.service;

import java.util.HashMap;
import java.util.List;

import com.ocean.main.entity.User;

public interface ManagerService {

    List<HashMap<String, Object>> findUserList(User user);//condition
    
    int addUser(User user);
    
    
}
