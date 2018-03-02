package testsimple;

import java.util.Random;


public class TestRandom {

    public static void main(String[] args) {
        
//        Random
//        int a = 0;
//        System.out.println(a++);
//        a= 0;
//        System.out.println(++a);
        
        System.out.println((int)((Math.random()*9+1)*10));
//        System.out.println(Math.random()*9+1);
//        System.out.println(RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble());
        Random random = new Random();
        System.out.println(random.nextInt(10000));
        System.out.println(random.nextDouble());
    }
}
