package WhiteBoarding_w9;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

3[a2[c]] => acc.repeat(3)

a2[c] => a + c.repeat(2) => acc

c.repeat(2)

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

multiplier => 2 + 0 * 10





 Constraints:
    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].
 */

//  class Solution {
//     public static void main(String[] args) {
  
//       System.out.println(deCode("2[abc]3[cd]ef"));
//     }
  
  
//     public static String deCode(String str) {
//       if(!str.contains("[") && !str.contains("]")) {
//         return str;
//       }
//       String result = "";
//       int[] open = {0, 0}; // keep track of initial open bracket at index 0, and count of open bracket at index 1
//       int[] close = {0, 0};
//       int multiplier = 1;
//       for(int i = 0; i < str.length(); i++) {
//         if(str.charAt(i) == '[') {
//           if(open[0] == 0) open[0] = i;
//           open[1] ++; 
//         } else if (str.charAt(i) == ']') {
//           close[0] = i;
//           close[1] ++;
//         } else if( Character.isDigit(str.charAt(i))) {
//           multiplier = Character.getNumericValue(str.charAt(i));
//         } else {
//           result += str.charAt(i);
          
//         }
//         System.out.println(result);
  
//         //Character.isDigit('5'); -> ~86
//         //Character.getNumericValue('5') -> 5
  
        
//         if(open[1] != 0 && (open[1] == close[1])) {
//           String subStr = str.substring(open[0] + 1, close[0]);
//           result += deCode(subStr).repeat(multiplier);
//         }
//       }
//       return result;
//     }
  
    // for loop to find matching brackets
    // run recursively of the  string inside bracket
//   }
  
public class DeCode {
    public static void main(String[] args) {
        System.out.println(getDecodedString("3[a]2[bc]"));
        System.out.println(getDecodedString("2[abc]3[cd]ef"));
        System.out.println(getDecodedString("3[a2[c]]"));
    }

    public static String getDecodedString(String str) {
        // if string has no brackets, return string
        if(!str.contains("[") && !str.contains("]"))
        return str;
        
        String result = "";
        int multiplier = 0;
        String subStr = "";
        int openCount = 0;
        int closeCount = 0;
        int i = 0;

        while((i < str.length())) {
            if(Character.isDigit(str.charAt(i)) && openCount == 0) {
                multiplier = Character.getNumericValue(str.charAt(i)) + (multiplier * 10);
            
            } else if (str.charAt(i) == '[') {
                if(openCount > 0) subStr += str.charAt(i);
                openCount++;
                
            } else if(str.charAt(i) == ']') {
                closeCount++;
                if(openCount > 0 && (openCount != closeCount)) subStr += str.charAt(i);

            } else if(multiplier == 0){
                result += str.charAt(i);

            } else {
                subStr += str.charAt(i);
            }
            i++;
            if((openCount == closeCount) && openCount != 0) {
                result += getDecodedString(subStr).repeat(multiplier > 0 ? multiplier : 1);
                if(i < str.length()) {
                    result += getDecodedString(str.substring(i, str.length()));
                }
                break;
            }
        }

        return result;

    }

    }



