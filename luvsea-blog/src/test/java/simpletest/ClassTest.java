package simpletest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassTest {

    public static void main(String[] args) {
        
        
        System.out.println(ClassTest.class.getSimpleName());
    }
    private String aaa ;
    private String AAA;
    @Test
    public void useTest(){
        System.out.println("this is test");
    }
    
    @Before
    public void bef(){
        System.out.println("zhiqiandiaoyong");
    }
    
    @After
    public void aft(){
        System.out.println(" this is after");
    }
    
//    @AnnotationTest
    public void testA(){
        System.out.println(" this is annotation");
    }
}
