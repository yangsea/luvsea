package TestView;


public class TestNew {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

//        ClassForTest.class.
//        Instance
//        ClassForTest cft =  (ClassForTest) Class.forName("TestView.ClassForTest").newInstance();
        ClassForTest cft = ClassForTest.class.newInstance();
        System.out.println(cft.getName());
    }

}
