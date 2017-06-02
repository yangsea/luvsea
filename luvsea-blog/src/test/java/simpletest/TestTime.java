package simpletest;

import java.sql.Timestamp;

public class TestTime {
    
    public static void main(String[] args) {
//        Timestamp ts = Timestamp.valueOf("1461136939000");
        Long sjc = 1452683375000l;
        Timestamp tsp = new Timestamp(sjc);
//        Timestamp tsp  =  Timestamp.parse("1461136939000");
        System.out.println(tsp);
    }

}
