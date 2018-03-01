package testsimple;

public class TestForWork {

	public static void main(String[] args) {
		
		testFloorNum();

	}
	
	
public static void testFloorNum(){
        
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        
        int level = 0;
        for (int i = 28000; i < 45000; i++) {
   		 // 三等奖
            if (i > 0 && i <= 5000 && i % 10 == 8) {
                a3++;
            }
            if (i > 5000 && i <= 32500 && (i % 100 == 88 || i % 100 == 55)) {
            	a3++;
            }
            // new add 
            if(i>5000&&i<45000&&i%100==26){
            	a3++;
            }
            // 二等奖
            // new add 
            if(i>0&&i<3000&&i%100==36){
            	a2++;
            }
            if (i > 0 && i <= 10000 && i % 100 == 66) {
            	a2++;
            }
            if (i > 10000 && i <= 45000 && i % 1000 == 666) {
            	a2++;
            }
            if (i > 0 && i <= 45000 && i % 1000 == 333) {
            	a2++;
            }
            // 一等奖
            if (i > 0 && i <= 9000 && i % 150 == 0) {
            	a1++;
            }
            if (i >= 9500 && i <= 34000 && i % 500 == 0) {
            	a1++;
            }
            // new add 0908
            if(0<i&&i<124&&i%62==0){
            	a1++;
            }
            // new add 
            if (i >= 130 && i <= 325 && i % 65 == 0) {
            	a1++;
            }
        }
        System.out.println(String.format("1等奖%d，二等奖%d，三等奖%d",a1,a2,a3));
    }
}
