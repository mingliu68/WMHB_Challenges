
// Problem 4:
//  Given a string Str. The task is to check if it is Pangram or not.

//   A pangram is a sentence containing every letter in the English Alphabet.

// Input: “the quick brown fox jumps over the lazy dog a”
// Output: is a Pangram
// Explanation: Contains all the characters from ‘a’ to ‘z’] 


package WhiteBoarding_w2;

import java.util.HashMap;

public class Pangram {
    public static void main(String[] args) {
        isPangram("the quick brown fox jumps over the lazy dog a");
    }

    public static void isPangram(String str) {
        // create a dictionary to keep track of the seen alphabets
        // loop thru the string toLowerCase();
        // get size of the dictionary at then end and if it's less than 26 return false;
        
        HashMap<Character, Boolean> seenChar = new HashMap<>();

        str.toLowerCase();

        str = str.replaceAll("\\s", "");
        // System.out.println(str);

        for(int i = 0; i < str.length(); i++) {
            if(!seenChar.containsKey(str.charAt(i))) {
                seenChar.put(str.charAt(i), true);
            }
        }
        System.out.println(seenChar.size() == 26 ? "is a Pangram" : "not a Pangram");


    }
}
