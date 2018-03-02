package testsimple;

public class TestPrime {

    public static void main(String[] args) {

        int prime[] = new int[100];
        for (int i = 0; i < 100; i++) {
            prime[i] = i+1;
        }
        for (int i = 1; i < prime.length; i++) {
            int tem = prime[i];
            boolean flag = true;
//            for (int j = 2; j < prime[i]; j++) {
//                if(tem %j==0){
//                    flag = false;
//                }
//            }
            for (int j = 2; j <= Math.sqrt(tem); j++) {
                if(tem %j==0){
                  flag = false;
              }
            }
            if(flag) System.out.println(tem);
        }
//        System.out.println((int)Math.sqrt(101));
    }

}
