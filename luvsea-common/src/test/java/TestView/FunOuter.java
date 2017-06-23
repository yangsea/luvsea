package TestView;

public class FunOuter {
    int out_x = 100;

    public void test() {
        class Inner {
            String x = "x";

            void display() {
                System.out.println(out_x);
            }
        }
        Inner inner = new Inner();
        inner.display();
    }

    public void showStr(String str) {
        // public String str1 = "test Inner";//不可定义，只允许final修饰
        // static String str4 = "static Str";//不可定义，只允许final修饰
        String str2 = "test Inner";
        final String str3 = "final Str";
        class InnerTwo {
            public void testPrint() {
                System.out.println(out_x);// 可直接访问外部类的变量
                // System.out.println(str);//不可访问本方法内部的非final变量
                // System.out.println(str2);//不可访问本方法内部的非final变量
                System.out.println(str3);// 只可访问本方法的final型变量成员
            }
        }
        InnerTwo innerTwo = new InnerTwo();
        innerTwo.testPrint();
    }

    public void use() {
        // Inner innerObj = new Inner();//此时Inner己不可见了。
        // System.out.println(Inner.x);//此时Inner己不可见了。
    }

    public static void main(String[] args) {
        FunOuter outer = new FunOuter();
        outer.test();
    }
}