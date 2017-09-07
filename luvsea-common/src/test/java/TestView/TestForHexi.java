package TestView;

import com.luvsea.common.basic.UtilString;

import net.sf.json.JSONObject;

public class TestForHexi {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        long b = 4;
//        if(5!=b){
//            System.out.println(true);
//        }
//        
//        JSONObject jo = new JSONObject();
//        jo.put("", "");
//        
//        Object  a = jo.get("num");
//        System.out.println(a);
//        
//        if(UtilString.isNull(jo.get("num"))){
//            System.out.println(" is koong");
//        }
//        
        
        int a1=0;
        for (int i = 0; i < 10000; i++) {
            if (i % 150 == 0) {
                a1++;
            }
        }
        System.out.println(a1);
    }

}
