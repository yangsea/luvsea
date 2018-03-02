package TestView;

public class TestArrayMulti {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        int[][] a = new int[3][4];
//        
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                a[i][j] = i*j; 
//            }
//        }
//        int tem = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                tem = a[i][j];
//                System.out.println(a[i][j]);
//            }
//        }

        int[] sum = new int[3]; 
        int[][] num = {{1,2,2,4},{5,6,7,8},{1,2,2,3}};
        for (int i = 0; i < num.length; i++) {
            int cj = 1;
            for (int j = 0; j < num[i].length; j++) {
                cj = cj*num[i][j];
                sum[i] = cj;
            }
            
        }
        System.out.println(sum[0]+sum[1]+sum[2]);

    }

}
