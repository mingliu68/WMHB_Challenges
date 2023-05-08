package WhiteBoarding_w9;


/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent 
row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 
with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 

Example 1:
Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Example 2:
Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01

Example 3:
Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

Constraints:

1 <= n <= 30
1 <= k <= 2^(n - 1)

Math.pow(2, n);
 */

public class OneAndZero {
    public static void main(String[] args) {
        System.out.println(getDigitAtK(1, 1));
        System.out.println(getDigitAtK(2, 1));
        System.out.println(getDigitAtK(2, 2));

        System.out.println(getDigitAtK(3,4));
        System.out.println(getDigitAtK(4, 7));
        System.out.println(getDigitAtK(5, 7));


    }

    public static Character getDigitAtK(int n, int k) {
       String baseStr = "";
       if(n == 1) {
        baseStr = "0";
        return baseStr.charAt(k-1);
       }
       if(n == 2) {
        baseStr = "01";
        return baseStr.charAt(k-1);
       }

       String str = helper(n);
       System.out.println(str);
       return str.charAt(k-1);

    }

    public static String helper(int currentRow) {
        if (currentRow == 2) {
            return "01";
        }
        String result = helper(currentRow - 1);
        return result + getZeroOne(result.substring(result.length() / 2));

    }

    public static String getZeroOne(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                result += "10";
            } else {
                result += "01";
            }
        }
        return result;
    }
}
