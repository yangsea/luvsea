package TestView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import sun.nio.ch.ThreadPool;

public class TestCollection {
    
    
    public static void main(String[] args) {
        
//        testLinkedList();
//        testVector();
            testArrayList();
            //使用线程池测试
//            ThreadPool
    }
    
    public static void testVector(){
        
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        for (Integer integer : v) {
            v.add(3); //在读取的时候操作会错误 =》java.util.ConcurrentModificationException
            System.out.println(integer);
        }
    }
    
    public static void testLinkedList(){
        
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        for (Integer integer : ll) {
            ll.add(3);
            System.out.println(integer);
        }
    }
    
public static void testArrayList(){
        
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        for (Integer integer : ll) {
            ll.add(3);
            System.out.println(integer);
        }
    }

}
