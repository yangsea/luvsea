package TestView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestWhile {
    
    public static void main(String[] args) {
        
        test2();
    }
    
    public void test1(){
        
        boolean flag = true ;
        int a = 100;
        do{
            
            if(a%7==0||a%13==0){
                
                System.out.println(a);
            }
            a--;
            if(a==0){
                flag = false;
            }
        }while(flag);
    }
    
    public static void test2(){
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 1; i <= 100; i++) {
//            System.out.println(i);
            set.add(i);
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            
            int a = it.next();
//            System.out.println(a);
            if(a%7==0||a%13==0){
                System.out.println(a);
            }
        }
    }

}
