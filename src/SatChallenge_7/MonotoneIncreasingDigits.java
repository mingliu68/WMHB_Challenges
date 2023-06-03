package SatChallenge_7;
/*
An integer has monotone increasing digits if and only if each pair of adjacent 
digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or equal to n
with monotone increasing digits.

 

Example 1:

Input: n = 10
Output: 9

Example 2:

Input: n = 1234
Output: 1234

Example 3:

Input: n = 332
Output: 299

 

Constraints:

    0 <= n <= 109
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(getMonotoneDigits(10));
        System.out.println(getMonotoneDigits(1234));

        System.out.println(getMonotoneDigits(299));

    }

    public static int getMonotoneDigits(int n) {
        // getting from the back to the front
        // example, 332, 2 failed 3 <= 2, so change 2 to 9, and reduce 3 to 2
        // now we have 329, 2 failed 3 <= 2, so change 2 to 9, and reduce 3 to 2
        // now we have 299, which satisfied 2 <= 9

        int division = 10;
        while(n / division > 0) {
            // int remainder = n % division;
            // int num = n / division;
            if(n % division < (n % (division * 100)) % division) {
                n = (((n / division) -1) * division) + 9;
            }
            division *= 10;
        }
        return n;
    }
}
