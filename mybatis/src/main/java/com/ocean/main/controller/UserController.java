//package com.ocean.main.controller;
//
//import java.sql.Timestamp;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
////@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
////@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    
//    @Resource(name="userServiceImpl")
//    private UserService userService;
//    
//    @Autowired
//    private CheckinService checkinService;
//    
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @RequestMapping(value="/showuser", method = RequestMethod.GET)
//    public String toIndex(HttpServletRequest request,Model model){
//        System.out.println("888888888888888888");
//
//            model.addAttribute("user can not in use");
//            System.out.println("can not get user");
//            User user=userService.getUserById(1);
//            System.out.println(user.getName());
////           System.out.println(user.toString());
//            model.addAttribute("user", user);
//            System.out.println("123");
//  
//            return "indexuser";
//    }
//    
//    
//    
//    @RequestMapping(value="/register.do",method= RequestMethod.POST)
//    public String registerIndex(HttpServletRequest request,Model model){
//        
//        //ModelAndView mav=new ModelAndView();
//
//        User userRegister=new User();
//        String username2=request.getParameter("username");
//        String password2=request.getParameter("password");
//        userRegister.setName(username2);
////      userRegister.setPassword(password2);
//        System.out.println(username2+"密码是"+password2);
//        
//        if(userRegister.getName()!=null){
//    
//            System.out.println(userRegister.getName()+" 显示注册的名字");
//            
//        }else{
//            
//            User user2 = new User();  
//            user2.setName("pm");  
////          user2.setPassword("pm");  
//        
//            userRegister=user2;         
//        }
//        
//        int id=this.userService.inster(userRegister);
//
//        User user=this.userService.getUserById(id);
//        
//        System.out.println(user.toString()+"insert user success");
//        
//        model.addAttribute("user", user);
//        
//        return "indexuser";
//    }
//
//        
//}
