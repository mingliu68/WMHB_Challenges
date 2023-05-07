package WhiteBoarding_w6;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a 
// different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

// Constraints:
//     1 <= prices.length <= 105
//     0 <= prices[i] <= 104

public class MaximizingProfit {
    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        int[] prices3 = {7,6,4,3,5,17,9,3,26,12,14};

        System.out.println(maximizingProfit(prices1));
        System.out.println(maximizingProfit(prices2));
        System.out.println(maximizingProfit(prices3));
    }

    public static int maximizingProfit(int[] prices) {
        if(prices.length == 1) return 0;
        if(prices.length == 2) {
            return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        }

        //code
        int left = 0;
        int right = 1;
        int max = 0;

        for(int i = 0; i < prices.length; i++) {
            while((left < prices.length - 1) && (right < prices.length) && (left < right)) {
                if (prices[left] > prices[right]) {
                    left++;
                    if(left == right) right++;
                } else {
                    max = prices[right] - prices[left] > max ? prices[right] - prices[left] : max;
                    right++;
                } 
            }
        }

        return max;
    }
}
