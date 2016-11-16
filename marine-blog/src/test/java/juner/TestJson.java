package juner;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TestJson {
    
    public static void main(String[] args) {
        
        List<Juner> junerList = new ArrayList<Juner>();
        Juner juner = new Juner();
        juner.setName("dandan");
        junerList.add( juner);
        juner = new Juner();
        juner.setName("choudandan");
        junerList.add(juner);
        String a = JSONObject.toJSONString(junerList,SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(a);
    }
}
