package WhiteBoarding_w7;

import java.util.HashMap;

// It is a sweltering summer day, and a boy wants to buy some ice cream bars.

// At the store, there are n ice cream bars. You are given an array costs of length n, 
// where costs[i] is the price of the ith ice cream bar in coins. 
// The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

// Note: The boy can buy the ice cream bars in any order.

// Return the maximum number of ice cream bars the boy can buy with coins coins.

// You must solve the problem by counting sort.

// Example 1:
// Input: costs = [1,3,2,4,1], coins = 7
// Output: 4
// Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.

// Example 2:
// Input: costs = [10,6,8,7,7,8], coins = 5
// Output: 0
// Explanation: The boy cannot afford any of the ice cream bars.

// Example 3:
// Input: costs = [1,6,3,1,2,5], coins = 20
// Output: 6
// Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
 
// Constraints:
// costs.length == n
// 1 <= n <= 105
// 1 <= costs[i] <= 105
// 1 <= coins <= 108

public class IceCreamBar {
    
}


class Solution {
    public static void main(String[] args) {
  
      Integer[] costs1 = {1,3,2,4,1};
      Integer[] costs2 = {10,6,8,7,7,8};
      Integer[] costs3 = {1,6,3,1,2,5};
      System.out.println(getIceCream(costs1, 7));
      System.out.println(getIceCream(costs2, 5));
      System.out.println(getIceCream(costs3, 20));
  
    }
    // Sorting: O(NlogN)
    // O(N)
  
    // sort array 
    // reducing coins by low to high value in array
  
    public static int getIceCream(Integer[] costs, int coins) {
  
      // hashmap keep track of ice cream costs
      // keep min cost 
      // start with key  = min and reduce coin by value 
      // then searching for prev key + 1 until there is a key with 
      // value then reduce coins until there is no more coins left
      // or not enough coins left
  
      HashMap<Integer, Integer> costMap = new HashMap<>();
      Integer min = costs[0];
      Integer max = costs[0];
      for(int i = 0; i < costs.length; i++) {

        min = costs[i] < min ? costs[i] : min;
        max = costs[i] > max ? costs[i] : max;
       
        if(costMap.containsKey(costs[i])) {
          Integer preVal = costMap.get(costs[i]);
          costMap.replace(costs[i], preVal + 1);
        } else {
          costMap.put(costs[i], 1);
        }
      }
      int count = 0;
      while(coins > 0 && (min <= max)) {
        if(costMap.containsKey(min)) {
          int maxQuantity = coins / min;
          // System.out.println(maxQuantity);
          if(maxQuantity >= 1) {
            if(costMap.get(min) < maxQuantity) {
              coins = coins - (min * costMap.get(min));
              count += costMap.get(min);
            } else {
              coins = coins - (min * maxQuantity);
              count += maxQuantity;
            }
          }  else break;
        }            
        min++;
      }
    return count;
  
    //   int count = 0;
    //   Arrays.sort(costs);
    //   for(int i = 0; i < costs.length; i++) {
    //     if(coins > 0 && coins >= costs[i]) {
    //       count++;
    //       coins-= costs[i];
    //     }
    //   }
  
    //   return count;
  
    // }
  
    }
  }
  