// Problem 5: 
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:

// Input: s = "rat", t = "car"
// Output: false

// Constraints:

//     1 <= s.length, t.length <= 5 * 104
//     s and t consist of lowercase English letters.

// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

// Maybe we can use ascii if the input contain Unicode chars? so the key value pair will be <Integer, Integer> 
// with the key being ascii value for the character

package WhiteBoarding_w2;

import java.util.HashMap;

public class AnagramWithin {
    public static void main(String[] arts) {

        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));

    }

    public static boolean isAnagram(String str1, String str2) {
        //creating two hashmaps, comparing one to the other by checking if the index (char) from one hashmap exist in the other
        // then comparing the quantity of such char (value)
        // return false either if key does not exist or value does not match

        HashMap<Character, Integer> strMap1 = new HashMap<>();
        HashMap<Character, Integer> strMap2 = new HashMap<>();
        fillDictionary(strMap1, str1);
        fillDictionary(strMap2, str2);
        for(Character key : strMap1.keySet()) {
            if(strMap2.containsKey(key) && strMap2.get(key) == strMap1.get(key)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void fillDictionary(HashMap<Character, Integer> map, String str) {
        for(int i = 0; i < str.length(); i++) { 
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), (map.get(str.charAt(i)) + 1));
            } else {
                map.put(str.charAt(i), 1);
            }
        } 

    }
} 
