package TestView;

public class TestCatch {
    
    public static void main(String[] args) {
        
        System.out.println(get());
    }
    
    public static int get(){
        
        try {
                return 1;
        }finally{
            return 2;
        }
    }

}
