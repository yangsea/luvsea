package simpletest;

public class GenericityTest<T> {

    T name;
    public void setName(T name) 
    { 
         this.name = name; 
    }    
} 

//这是泛型。这个 T 的，是由你在new一个类时，而传进来的类型。 
//Student<String> stu = new Student<String>(); 
//stu.setName(1); // 报错，不符合,因为在new的时候给的是String类型 
//stu.setName("string"); // 正确 
//       
//       
//Student<Integer> stu1 = new Student<Integer>(); 
//stu1.setName(1); // 正确 
//stu1.setName("string"); // 报错，不符合,因为在new的时候给的是Integer类型