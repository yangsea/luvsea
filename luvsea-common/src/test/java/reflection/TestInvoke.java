package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestInvoke {

    public static void main(String[] args) 
            throws InstantiationException, IllegalAccessException, NoSuchMethodException
            , SecurityException, IllegalArgumentException, InvocationTargetException {

        Class<TestUser> testUser = TestUser.class;
        TestUser tu =  testUser.newInstance();
        Method method  = testUser.getMethod("getName", String.class);
        Object o = method.invoke(tu, "menameissea");
        System.out.println(o);
    }

}

class TestUser {
    
  private String name;
  
  public String getName(String name){
      this.name = name;
      return this.name;
  }

}
