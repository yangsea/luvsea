package com.ocean.main.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocean.main.common.JsonResult;
import com.ocean.main.entity.User;
import com.ocean.main.service.UserService;

@Controller
@RequestMapping(value="/manage")
public class ManagerAction {
    
    @Autowired
    private UserService userService;

  @RequestMapping("/login")
//  @ResponseBody
  public @ResponseBody JsonResult<String> login(String userName, String passWord, HttpSession session ){
      //注意拦截器
     //注意统一登录：用户名、邮箱、手机号码，  》》》》单点登录
      JsonResult<String> jsonR = new JsonResult<String>();
      User paraUser = new User();
//      paraUser.setUserName("dooriya");
//      paraUser.setPassWord("123456");
      paraUser.setUserName(userName);
      paraUser.setPassWord(passWord);
      User user = this.userService.findUserBySelected(paraUser);
      if(user!=null&&user.getId()>0){
          session.setAttribute("user", user);
          System.out.println("come in login contrallor@@@@@@@"+user.getUserName());
//          session.setMaxInactiveInterval(900);
      }else{
          System.out.println("账户或密码错误！");
          //登录需要用异步判断正确与错误
          jsonR.setRet(1);
      }

      return jsonR;
  }
    
    //go login
    @RequestMapping("/toLogin")
    public String goLogin(){
        
        return "manager/login";
    }
    
     
    //权限控制，后台使用bootstrap
    public String getMenuByRoleId(){
        return "";
    }
    
    public String getUserList(){
        
        return "";
    }
    
    @RequestMapping("toMain")
    public String toMain(){
        
        return "manager/main";
    }
    
    
}
