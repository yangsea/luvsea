//package com.ocean.frame.main.action;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.vaadin.Application;
//import com.vaadin.ui.Alignment;
//import com.vaadin.ui.GridLayout;
//import com.vaadin.ui.LoginForm;
//import com.vaadin.ui.Window;
//import com.vaadin.ui.LoginForm.LoginEvent;
//
//import simpletest.vaddin.TestVaddinApplicationMain;
//
//@Controller
//@RequestMapping("/test")
//public class TestController extends Application {
//
//    @RequestMapping("/testVaadin")
////    @ResponseBody
//    public String testVaadin(){
//
//       this.init();
//        return "";
//    }
//    
//    @Override
//    public void init() {
//       
//        System.out.println("come@@@@@@@@@@@@@@@@@@@@");
//        final GridLayout layout = new GridLayout(1, 1);
//        layout.setMargin(true);
//        LoginForm login = new LoginForm();
//        login.setWidth("100%");
//        login.setHeight("300px");
//        login.setLoginButtonCaption("登录");
//        login.setUsernameCaption("用户名：");
//        login.setPasswordCaption("密    码");
//        login.addListener(new LoginForm.LoginListener() {
//            public void onLogin(LoginEvent event) {
//                getMainWindow().showNotification(
//                        "New Login",
//                        "Username: " + event.getLoginParameter("username")
//                                + ", password: "
//                                + event.getLoginParameter("password"));
//            }
//        });
//        Window mainWindow = new Window("登录窗口",layout);
//        layout.addComponent(login);
//        layout.setComponentAlignment(login, Alignment.TOP_CENTER);
//        setMainWindow(mainWindow);
//   
//    }
//}
