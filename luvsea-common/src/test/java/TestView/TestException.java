package TestView;
public class TestException extends Exception
{
        TestException(String msg)
        {
                super(msg);
        }
        
        public static void main(String[] args) 
        {
                Test t =null;
                try
                {
                        t =new Test(-1);
                }
                catch (Exception e)
                {
                        System.out.println(e.toString());
                }
                System.out.println(t.toString());//如果出错时也创建对象则会返回对象引用，如果不创建对象则是空指针异常
        }
}

class Test
{
        Test(int n) throws TestException
        {
                if(n<0)
                        throw new TestException("出错");

        }
}

