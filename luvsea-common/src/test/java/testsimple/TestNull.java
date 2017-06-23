package testsimple;

import java.util.List;

public class TestNull {
    
    public static void main(String[] args) {
        
        List a = null;
        if(null==a||a.size()==0){
            System.out.println("is ok");
        }
    }

}
