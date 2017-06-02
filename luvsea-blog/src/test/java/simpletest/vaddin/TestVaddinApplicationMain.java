//package simpletest.vaddin;
//
//import com.vaadin.Application;
//import com.vaadin.ui.*;
//import com.vaadin.ui.LoginForm.LoginEvent;
//
//import java.io.*;
//import java.util.Locale;
//
//import org.junit.Test;
//
//
//public class TestVaddinApplicationMain extends Application {
//    
//    @Override
//    public void init() {
//       
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
//
//}