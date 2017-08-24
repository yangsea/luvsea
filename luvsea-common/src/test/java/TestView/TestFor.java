package TestView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFor {

    public static void main(String[] args) {

        testIterator();
    }

    public static void testIterator(){
        
        Set<Integer> a = new HashSet<Integer>();
        for (int i = 0; i < 10000000; i++) {
            a.add(i);
        }
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for(int i=0;i<2;i++)
        {
            if(i==0){
                pool.execute(
                        new Runnable() {
                            public void run() {
                                long start = System.currentTimeMillis();
                                for(Iterator<Integer> i=a.iterator();i.hasNext();){
//                                    System.out.println(i.next());
                                    int a = i.next();
                                }
                                long end = System.currentTimeMillis();
                                System.out.println("for:"+(end-start));
                            }
                        } );
            }
            if(i==1){
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        Iterator<Integer> it = a.iterator();
                        long start = System.currentTimeMillis();
                        while(it.hasNext())
                        {
//                            System.out.println(it.next());
                            int b = it.next();
                        }
                        long end = System.currentTimeMillis();
                        System.out.println("while:"+(end-start));
                    }
                });
            }
        }
        pool.shutdown();
    }
}
