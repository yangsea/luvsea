package testsimple;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.luvsea.common.basic.UtilString;


public class TestJSON {

    
    public static void main(String[] args) {
//        
//        User user = new User();
//        user.setCity("襄阳");
//        JSONObject jsonObject = JSONObject.fromObject(user);
//        System.out.println(jsonObject.toString());
//        int a =1 ;
//        int b = 2;
//        System.out.println("{\"enterpriseid\":11,\"mobile\":"+a+",\"openid\":\""+b+",\"logintype\":1}");
        
//        System.out.println("\""+File.separator+"\"");
//        String path = request.getSession().getServletContext().getRealPath(""); 
//        System.out.println(path+"xiangmudizhi");
//        System.out.println("dizhi"+request.getServletPath());
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
//        request.getSession().setAttribute("testS", "session测试");
        
        
       JSONObject jsonO = new JSONObject();
       jsonO.put("test", "dddd");
       System.out.println(UtilString.isNull(jsonO));
       
    }
    
    @Test
    public void test(){
        
//        JSONObject jsonO = new JSONObject();
        net.sf.json.JSONObject jsonO = new net.sf.json.JSONObject();
        jsonO.put("test", jsonO);
//        jsonO.put("aaaaa", "");
        String a = String.valueOf(jsonO.get("aaaaa"));
        System.out.println("f"+jsonO.get("aaaaa"));
        if("null".equals(a))
            System.out.println("a is null");
        System.out.println(a);
        System.out.println(UtilString.isNull(jsonO.get("test")));
    }
}
