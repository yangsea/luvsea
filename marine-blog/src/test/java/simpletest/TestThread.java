package simpletest;

public class TestThread implements Runnable {
    
    @Override
    public void run() {

          try {
              for (int i = 0; i < 100; i++) {
                  System.out.println(" come in this is thread ");
                  Thread.sleep(1000);
              }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TestThread tt = new TestThread();
        Thread t = new Thread(tt);
        t.start();
    }

}
