package TestView;

import java.util.List;

public class TestOld {

    public static Object getObject(List list){
        
        list.add(1);
        return list.get(0);
    }
}