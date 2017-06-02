package com.luvsea.blog.dao.user;

import java.util.HashMap;
import java.util.List;

import com.luvsea.blog.entity.Test;
import com.luvsea.blog.entity.User;

public interface UserDao {
    
    public List<User> findUserList();
    public int testAdd (Test test);
    public List<HashMap<Object, Object>> findListByProtocal();
    public User findUserBySelected(User user);
    
}
