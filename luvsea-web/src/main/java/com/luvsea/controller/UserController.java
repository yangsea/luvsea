package com.luvsea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luvsea.service.impl.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    
//    @Autowired
//    private UserService userService;
    UserService userService = new UserService();
    
    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        
        String str = userService.getUser();
        
        return "this is getUser > " + str;
    }

//@RequestMapping("/hello")
//public String getHelloName(@RequestParam(value = "name",required = true) String name){
//    return "Hello ->"+name;
//}
}
