package testsimple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static String checkOption(String option, String _date) {  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
            Calendar cl = Calendar.getInstance();  
            Date date = null;  
      
            try {  
                date = (Date) sdf.parse(_date);  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
            cl.setTime(date);  
            if ("pre".equals(option)) {  
                // 时间减一天  
                cl.add(Calendar.DAY_OF_MONTH, -1);  
            } else if ("next".equals(option)) {  
                // 时间加一天  
                cl.add(Calendar.DAY_OF_YEAR, 1);  
            } else {  
                // do nothing  
            }  
            date = cl.getTime();  
            return sdf.format(date);  
        }  
    
    public static void main(String[] args) {
        
       System.out.println( checkOption("next","2017-02-28"));;
    }
}

