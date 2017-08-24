package testpackage;

public class TestA {

    public static void main(String[] args) {
        
//        int a = 2111 % 1000;
//        System.out.println(a);
//        
//        int second = 1668 % 100;
//        System.out.println(second);
        
//        int readyNum = 10023;
//        if(readyNum % 100==111)
        
//        int thi = 211 % 10;
//        System.out.println(thi);
//        
//        System.out.println(1993 / 10);
//        
//        int b = 1000;
        
//        if(b>100){
//            if(b%100)
//        }
//        System.out.println(b % (String.valueOf(b).length()*10)==Integer.valueOf(String.valueOf(b).substring(1)));
//        
//        if(b % String.valueOf(b).length()*10==11){
//            
//        }
        
        int num  = 20333;
        int s = num / 1000;
        if(s > 0){
            num = num - 1000*s;
        }
        if(num % 111 == 0){
            System.out.println("=======");
        }
        
        int num2 = 2118;
        int s2=num2/100;
        if(s2>0){
            num2 = num2-100*s2;
        }
        System.out.println(num2);
        if(num/10 ==8 || num==38 || num==68 || num==98){
            System.out.println("-----------");
        }
        
        
    }
    
    
}
