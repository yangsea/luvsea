package testsimple;

public class TestScope extends TestBase {

    private int testThis;
    public static void main(String[] args) {
        
    }
    
    public void test(){
        
        int a = this.testSco;
        TestScope ts = new TestScope();
        this.setTestSc(1);
        ts.setTestSc(1);
    }
}
