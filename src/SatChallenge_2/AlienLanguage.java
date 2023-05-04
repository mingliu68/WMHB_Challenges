package SatChallenge_2;

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
        
    }

    // first check the first char of each word and see if they are in order according to the new alien order
    // second check if there are any words with the same starting char
    // if there are words with the same char, then comparing them individually char to char

    // str.indexOf("subString") to get index of the first substring occurance

    public static boolean isItValid(String[] strArr, String order) {
        

        for(int i = 1; i < strArr.length; i++) {
            if(order.indexOf(strArr[i].charAt(0)) < order.indexOf(strArr[i-1].charAt(0))) return false;
            
        }

        return true;
    }
}
