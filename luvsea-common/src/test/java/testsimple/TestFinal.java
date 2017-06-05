package testsimple;

public class TestFinal {

    public static void main(String[] args) {

        final int[] a = {1,2,3};
        a[0] = 9;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
//        a =new int[] {2,3,4};
    }

}
