package testpackage;

public class Testt {
    
    public static void main(String[] args) {
        
        int first = 0 ;
        int second = 0 ;
        
        for (int i = 15000; i < 19230; i++) {
            
            int num = i;
            int s = num / 1000;
            if(s > 0){
                num = num - 1000*s;
            }
            if(num % 111 == 0){
                //二等奖                
                first ++;
            }
            
            int s2=num/100;
            if(s2>0){
                num = num-100*s2;
            }
            if(num % 8==0 || num%38==0 || num%68==0 || num%98==0){
                //三等奖
                second ++;
            }
        }
        System.out.println(first+"|"+second);
        
    }

}
