package SatChallenge_2;

// Given a string s, reverse the string according to the following rules:

//     All the characters that are not English letters remain in the same position.
//     All the English letters (lowercase or uppercase) should be reversed.

// Return s after reversing it.


// Example 1:
// Input: s = "ab-cd"
// Output: "dc-ba"

// Example 2:
// Input: s = "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"

// Example 3:
// Input: s = "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"

 

// Constraints:
//     1 <= s.length <= 100
//     s consists of characters with ASCII values in the range [33, 122].
//     s does not contain '\"' or '\\'.

public class ReverseString {
    public static void main(String[] args) {
        

        System.out.println(reverseString("a-bC-dEf-ghIj"));
        System.out.println(reverseString("ab-cd"));
        System.out.println(reverseString("Test1ng-Leet=code-Q!"));
    }

    // ascii
    // 65 - 90 inclusive 
    // 97 - 122 inclusive

    public static String reverseString(String str) {
        int start = 0;
        int end = str.length() - 1;
        char[] charArr = str.toCharArray(); 

        while (end > start) {
            if(!Character.isAlphabetic(charArr[start])) {
                start++;
            }
            if(!Character.isAlphabetic(charArr[end])) {
                end--;
            }
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;

            
        }

        return new String(charArr);
    }


}
