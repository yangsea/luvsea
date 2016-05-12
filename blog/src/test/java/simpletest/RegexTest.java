package simpletest;

public class RegexTest {
    
    public static void main(String[] args) {
        
        String aaa = "plain";
//        boolean bbb = aaa.matches("a|||||||b||||c");
//        if(bbb) System.out.println("zhen"); else System.out.println("jia");;
//        
        boolean bbb = aaa.matches("[^abc]+");  //只能匹配一个
        if(bbb) System.out.println("zhen"); else System.out.println("jia");;
        
    }

}
