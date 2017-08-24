package testsimple;

import java.util.Scanner;

public class TestScanner {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
//        System.out.println("消费金额：");
//        double result = scanner.nextDouble();
//        result = result * 0.8;
//        System.out.println("商品价格:"+result);
        
        System.out.println("请输入4位会员卡号：");
        String memCard = scanner.next();
        if(memCard.length()==4){
            String[] cardSite = memCard.split("");
            int total=0;
            for (String string : cardSite) {
                total+=Integer.valueOf(string);
            }
            System.out.println("会员卡号"+memCard+"各位之和："+total);
            System.out.println("是幸运客户吗？"+(total>20?"true":"false"));
        }else{
            System.out.println("会员卡格式不正确~");
        }
        scanner.close();
    }
}
