package testsimple;

import java.math.BigInteger;

import org.junit.Test;

public class TestErrorCheck {

//    private String temp = "";
    void doSomething(){
        //tem作用域为本方法，不要画蛇添足！
//        private String tem = "";
        
    }
    @Test
    public void testAdd() {
//        int a = 1;
//        ++a;
//        System.out.println(a);
        
//        BigInteger
        
        String c = "ddd";
        c.length();
        
        int[] b = {1,2,3,5,6,8};
        int i ;
        for (i = 0; i < b.length&&b[i]>0; i++) {
            System.out.println(i);
        }
        System.out.println(b.length);
    }
}
