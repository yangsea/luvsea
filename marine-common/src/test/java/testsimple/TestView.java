package testsimple;

public class TestView {
    
    public static void main(String[] args) {
        
        doubleNum(2);
    }
    
    public static void doubleNum(int n){
        
       System.out.println(n);
       if(n<=30){
           doubleNum(n*2);
       }
       System.out.println("sencond"+n);     //为什么会单独再循环四次呢？
    }
//Gaibaota(N) = Gaibaota(N-1) + n
    
//    public static void selfN(int n){
//        
//        System.out.println(n);
//        for (int i = n; i < 5; i++) {
//            selfN(n++);
//        }
//        System.out.println("is ok");
//    }

}
