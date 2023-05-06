package WhiteBoarding_w4;

import java.util.HashMap;

import javax.swing.plaf.FontUIResource;

// You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

//     Characters ('a' to 'i') are represented by ('1' to '9') respectively.
//     Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.

// Return the string formed after mapping.

// The test cases are generated so that a unique mapping will always exist.

 

// Example 1:

// Input: s = "10#11#12"
// Output: "jkab"
// Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

// Example 2:

// Input: s = "1326#"
// Output: "acz"

 

// Constraints:

//     1 <= s.length <= 1000
//     s consists of digits and the '#' letter.
//     s will be a valid string such that mapping is always possible.

public class MappingString {


    private static HashMap<String, Character> map;


   
    



    public static void main(String[] args) { 
        map = new HashMap<>();
        
        for(int i = 1; i < 27; i++) {
        if(i < 10) {
            map.put(String.valueOf(i), (char)(96+i));
        } else {
            map.put(String.valueOf(i) + "#",(char)(96+i));
        }
        
    }
        
    
    System.out.println(mapToString("10#11#12"));
    System.out.println(mapToString("1326#"));

    }

    public static String mapToString(String str) {

        String prev = "";
        
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '#') {
                prev += str.charAt(i);
            } else {
                String end = map.get(prev.substring(prev.length() - 2) + "#") + "";
                if(prev.length() > 2) {
                    for(int j = 0; j < prev.length() - 2; j++) {
                        result += map.get(prev.charAt(j) + "");
                    }
                }
                prev = "";
                result += end;
            }
        }
        for(int i = 0; i < prev.length(); i++) {
            result += map.get(prev.charAt(i) + "");
        }

        return result;
    }
}
