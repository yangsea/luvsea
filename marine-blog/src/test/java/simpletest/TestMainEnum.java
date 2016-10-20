package simpletest;

import org.junit.Test;

public class TestMainEnum {

    @Test
    public void testObj(){
        int id = TestEnum.a.entityTestEnum.getId().intValue();
        System.out.println(id);
    }
}
