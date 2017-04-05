package simpletest;

public class TestDate {

    public static void main(String[] args) {
        
//        Date date = new Date();
        
        
//        System.out.println(Boolean.valueOf("true"));
        
        String b = "true";
        if(b.equals("true")||b.equals("false")){
            int a = Boolean.valueOf(b)?1:0;
            System.out.println(a);
        }
    }
}
