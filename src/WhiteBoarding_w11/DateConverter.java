package WhiteBoarding_w11;

import java.util.HashMap;

// Given a date string in the form Day Month Year, where:

//     Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
//     Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
//     Year is in the range [1900, 2100].

// Convert the date string to the format YYYY-MM-DD, where:

//     YYYY denotes the 4 digit year.
//     MM denotes the 2 digit month.
//     DD denotes the 2 digit day.

// Example 1:
// Input: date = "20th Oct 2052"
// Output: "2052-10-20"

// Example 2:
// Input: date = "6th Jun 1933"
// Output: "1933-06-06"

// Example 3:
// Input: date = "26th May 1960"
// Output: "1960-05-26"

// Constraints:
//     The given dates are guaranteed to be valid, so no error handling is necessary.

public class DateConverter {

    public static void main(String[] args) {
        System.out.println(convertDate("26th May 1960"));
        System.out.println(convertDate("20th Oct 2052"));
        System.out.println(convertDate("6th Jun 1933"));

    }

    public static String convertDate(String dateStr) {
        
        String[] monthArr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        HashMap<String, String> month = new HashMap<>();
        for(int i = 0; i < monthArr.length; i++) {
            String mon = i + 1 > 9 ? String.valueOf(i+1) : "0" + String.valueOf(i+1);
            month.put(monthArr[i], mon);
        }
        String[] dateArr = dateStr.split(" ");
        String day = dateArr[0];

        for(int i = day.length() - 1; i >= 0; i--) {
            if(Character.isDigit(day.charAt(i))) {
                day = day.substring(0, i+1);
                if(day.length() < 2) {
                    day = "0" + day;
                }
                break;
            }
        }

        return dateArr[2] + "-" + month.get(dateArr[1]) + "-" + day;
        
    }
    
}
