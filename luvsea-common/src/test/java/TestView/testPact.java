package TestView;

public class testPact {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int a = 60;
        int b = 560;
        for (int i = a; i >0; i--) {
            if(a%i==0&&b%i==0){
                System.out.println("最大公约数是："+i);
                break;
            }
        }
        //最小公倍数
        
    }

}
