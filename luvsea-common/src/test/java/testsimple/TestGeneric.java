package testsimple;

public class TestGeneric<T> {

    T result;
    
    
    
    public static void main(String[] args) {
        TestGeneric<?> aaa = new TestGeneric<>();
        
//        String o = aaa.result;
//        aaa.result = "im suc";
//        String aa = aaa.result;
//        System.out.println(aa);
    }
}
