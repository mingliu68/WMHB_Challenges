package WhiteBoarding_w11;

import java.util.HashMap;

// Given an integer, return a string containing the english pronounciation of the number.
// Ex.     125856  -> "one hundred twenty five thousand eight hundred fifty six"
//     1000005 -> "one million five"
//     12013   -> "twelve thousand thirteen"
// The number will be between 0 and 999,999,999,999 (inclusive)

public class NumberInEnglish {
    
    static HashMap<Character, String[]> map = generatingMap();
    
    public static void main(String[] args) {
        
        System.out.println(getNumberInEnglish(125856));
    }

    public static String getNumberInEnglish(int num) {
           
        String numStr = Integer.valueOf(num).toString();
        String result = "";
        Integer division;
        Integer remainder;
        for(int i = 0; i < numStr.length(); i++) {
            if(i > 2 && i % 3 == 0) {
                division = i / 3;
                result = map.get((char)(division + '0'))[3] + " " + result;
            }
            remainder = i % 3;
            result = map.get(numStr.charAt(numStr.length() - 1 - i))[remainder] + " " + result;

        }

        return result;
    }



    private static HashMap<Character, String[]> generatingMap() {
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('1', new String[]{ "one", "ten", "one hundred", "thousand"});
        map.put('2', new String[]{"two",  "twenty","two hundred", "million"});
        map.put('3', new String[]{"three","thirty", "three hundred",  "billion"});
        map.put('4', new String[]{"four","forty","four hundred"  });
        map.put('5', new String[]{ "five","fifty", "five hundred" });
        map.put('6', new String[]{"six","sixty", "six hundred" });
        map.put('7', new String[]{"seven","seventy","seven hundred"  });
        map.put('8', new String[]{"eight","eighty", "eight hundred" });
        map.put('9', new String[]{"nine", "ninety","nine hundred" });


        return map;
    }
}
