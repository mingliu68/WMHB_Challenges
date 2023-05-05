package SatChallenge_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// In an alien language, surprisingly, they also use English lowercase letters, 
// but possibly in a different order. The order of the alphabet is some permutation of 
// lowercase letters.

// Given a sequence of words written in the alien language, and the order of the alphabet, 
// return true if and only if the given words are sorted lexicographically in this alien language.

// Example 1:
// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

// Example 2:
// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 
// hence the sequence is unsorted.

// Example 3:
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
// According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined 
// as the blank character which is less than any other character.

public class AlienLanguage {
    public static void main(String[] args) {

        String[] words1 = {"hello","leetcode"};
        String[] words2 = {"word","world","row"};
        String[] words3 = {"apple","app"};

        System.out.println(isItValid(words1, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isItValid(words2, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isItValid(words3, "abcdefghijklmnopqrstuvwxyz"));

    }   

    
    // str.indexOf("subString") to get index of the first substring occurance

    public static boolean isItValid(String[] strArr, String order) {
        // comparing first char of each string in strArr, 
        // if there are strings with the same first char, recursively run those strings
        // if all in order then return true
        // else return false;

        // ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));
        // int maxLength = list
        //                 .stream()
        //                 .map(String::length)
        //                 .max(Integer::compare)
        //                 .get();


        // substring arrays for further recursive function for words with same first char
        ArrayList<String> subString = new ArrayList<>();

        Character prevChar = null;
        Character currentChar = null;
        
        for(int i = 0; i < strArr.length; i++) {  
            // if empty, must be ahead
            if((i != 0) && (strArr[i].length() == 0) && (strArr[i-1].length() > 0)) {
                return false;
            }
            prevChar = currentChar;
            if(strArr[i].length() > 0) {
                currentChar = strArr[i].charAt(0);
            } else {
                currentChar = null;
            }
                      
            // if current char order lower than prev char order, return false
            if(prevChar != null && (order.indexOf(currentChar) < order.indexOf(prevChar))) {
                return false;
            }
            // if current char is the same as prev char, add substring to arraylist for further recursive action
            if(currentChar == prevChar) {
                subString.add(strArr[i].substring(1));
            } 
            // if current char is not the same as prev char, and subString has only one or zero items, add/replace item at index 0
            else if (subString.size() <= 1) {
                subString.clear();
                subString.add(strArr[i].substring(1));
            } 
            // if current char is not the same and substring has more than one items, run recursive function
            else {
                if(isItValid(subString.toArray(new String[subString.size()]), order) == false) return false;
                subString.clear();
                subString.add(strArr[i].substring(1));
            }
        }
        if(subString.size() > 1) {
            return isItValid(subString.toArray(new String[subString.size()]), order);
        }
        

        return true;
    }
}
