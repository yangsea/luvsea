package com.luvsea.blog.service;

import java.util.HashMap;
import java.util.List;

import com.luvsea.blog.entity.User;

public interface ManagerService {

    List<HashMap<String, Object>> findUserList(User user);//condition
    
    int addUser(User user);
    
    
}
