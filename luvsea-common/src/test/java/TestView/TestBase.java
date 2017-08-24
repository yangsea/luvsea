package TestView;

public class TestBase {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int i = 1, j = 0,k=0,a=0,b=0;
        i=(--a==b++)? --a:++b;
        j=a++;k=b;
        System.out.println(i +"|"+j+"|"+k);
//        2|-1|2
    }
}
