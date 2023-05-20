package misc;

import java.util.Calendar;
import java.util.HashMap;


public class JodaTimeTesting {

    private static HashMap<String, String> month = new HashMap<>();
    

    public static void main(String[] args) {
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        System.out.println("-------------------");
        Calendar c = Calendar.getInstance();
        System.out.println("Current Date: " + c.getTime());
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(2023, 3, 27);
        System.out.println("Reset Date: " + c.getTime());
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("After getting start day on Monday: " + c.getTime());
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("After getting start day on Monday 2nd time: " + c.getTime());
        String[] weeklyDates = new String[7];
        System.out.println(weeklyDates.length);



        // System.out.println("-------------------");
        // Calendar c = Calendar.getInstance();
        // c.setFirstDayOfWeek(Calendar.MONDAY);
        // System.out.println("current Date: " + c.getTime());
        // c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // System.out.println("current Monday: " + c.getTime());
        // c.add(Calendar.DATE, 7);
        // System.out.println("next: " + c.getTime());
        // c.add(Calendar.DATE, -14);
        // System.out.println("prev: " + c.getTime());
        // c.add(Calendar.DATE, 7);
        // System.out.println("current: " + c.getTime());

        // Calendar c = Calendar.getInstance();
        // Calendar a = Calendar.getInstance();
        // System.out.println("------------------------");
        // System.out.println("Before setting c to Monday: " + c.getTime());
        // c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // System.out.println("After setting c to Monday: " + c.getTime());
        
        // String[] str = c.getTime().toString().split(" ");
        
        // Long userId = (long)(332);
        // System.out.println("CustomID: " + userId + str[5] + month.get(str[1]) + str[2]);
        // System.out.println(c.getTime());
        // System.out.println(a.getFirstDayOfWeek());
        // c.add(Calendar.DATE, 7);
        // System.out.println("After adding 7 days to c: " + c.getTime());
        // Calendar cClone = (Calendar)c.clone();
        // cClone.add(Calendar.DATE, -7);
        // System.out.println("cClone date should be 7 days prior to c: " + cClone.getTime() );
        // System.out.println("c should be 7 days after cClone: " + c.getTime());
    }
   
    
    
    
}
