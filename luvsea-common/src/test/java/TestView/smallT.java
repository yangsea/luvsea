package TestView;

public class smallT {
    public static void main(String args[]) {
        smallT t = new smallT();
        int b = t.get();
        System.out.println(b);
    }

    public int get() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}