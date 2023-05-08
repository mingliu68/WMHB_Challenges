package WhiteBoarding_w11;

import java.util.ArrayList;
import java.util.Arrays;

// You are given an array of strings products and a string searchWord.

// Design a system that suggests at most three product names from products after each character of searchWord is typed. 
// Suggested products should have common prefix with searchWord. If there are more than three products with a common 
// prefix return the three lexicographically minimums products.

// Return a list of lists of the suggested products after each character of searchWord is typed.

// Example 1:
// Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
// Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
// Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
// After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
// After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

// Example 2:
// Input: products = ["havana"], searchWord = "havana"
// Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// Explanation: The only word "havana" will be always suggested while typing the search word.

// Constraints:
//     1 <= products.length <= 1000
//     1 <= products[i].length <= 3000
//     1 <= sum(products[i].length) <= 2 * 104
//     All the strings of products are unique.
//     products[i] consists of lowercase English letters.
//     1 <= searchWord.length <= 1000
//     searchWord consists of lowercase English letters.

public class ThreeProductNames {
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String[] cities = {"havana"};
        // Arrays.sort(products);
        // System.out.println(Arrays.toString(products));        

        System.out.println(getProducts(products, "mouse"));
        System.out.println(getProducts(cities, "havana"));
    }

    public static ArrayList<ArrayList<String>> getProducts(String[] products, String searchWord) {
        // if arraylist result contains noarrays, search the entire product array
        // if arraylist result contains arrays, search the previous (last array in result) for matching products

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        Arrays.sort(products);

        String searchSub = "";

        for(int i = 0; i < searchWord.length(); i++) {

            searchSub = searchWord.substring(0, i+1);

            ArrayList<String> subList = new ArrayList<>();

            // if result.size is 0, search the entire product array
           
                
                for(int j = 0; j < products.length; j++) {
                  // if list already have 3 items, break
                  if(subList.size() >= 3) break; 
                  if(products[j].substring(0, i+1).equals(searchSub)){
                    subList.add(products[j]);
                  }
                }
        
            result.add(subList);
        }

        return result;
    }
}
