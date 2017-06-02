package testsimple;

import org.junit.Test;

public class TestViews {
    
    /** 原理 
     * 比较相邻两个大小，大的往前移，或者小的往前移
     * 
     * */
    @Test 
    public void testSort(){
        
        int [] a = {4,3,8,10,22};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int tmp = 0;
                if(a[i]<a[j]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

}
