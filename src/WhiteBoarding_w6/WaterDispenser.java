package WhiteBoarding_w6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// You have a water dispenser that can dispense cold, warm, and hot water. 
// Every second, you can either fill up 2 cups with different types of water,
// or 1 cup of any type of water.

// You are given a 0-indexed integer array amount of length 3 where amount[0], 
// amount[1], and amount[2] denote the number of cold, warm, and hot water cups 
// you need to fill respectively. Return the minimum number of seconds needed 
// to fill up all the cups.

// Example 1:
// Input: amount = [1,4,2]
// Output: 4
// Explanation: One way to fill up the cups is:
// Second 1: Fill up a cold cup and a warm cup.
// Second 2: Fill up a warm cup and a hot cup.
// Second 3: Fill up a warm cup and a hot cup.
// Second 4: Fill up a warm cup.
// It can be proven that 4 is the minimum number of seconds needed.

// Example 2:
// Input: amount = [5,4,4]
// Output: 7
// Explanation: One way to fill up the cups is:
// Second 1: Fill up a cold cup, and a hot cup.
// Second 2: Fill up a cold cup, and a warm cup.
// Second 3: Fill up a cold cup, and a warm cup.
// Second 4: Fill up a warm cup, and a hot cup.
// Second 5: Fill up a cold cup, and a hot cup.
// Second 6: Fill up a cold cup, and a warm cup.
// Second 7: Fill up a hot cup.

// Example 3:
// Input: amount = [5,0,0]
// Output: 5
// Explanation: Every second, we fill up a cold cup.

// Constraints:
//     amount.length == 3
//     0 <= amount[i] <= 100




public class WaterDispenser {
    public static void main(String[] args) {
        int[] amount1 = {1,4,2};
        int[] amount2 = {5,4,4};
        int[] amount3 = {5,0,0};
        System.out.println(totalSeconds(amount1));
        System.out.println(totalSeconds(amount2));
        System.out.println(totalSeconds(amount3));
    }

    
    public static int totalSeconds(int[] amount) {

        int[] newAmount = eliminateZeroSort(amount);

        // recursive
        if(newAmount.length == 0) return 0;
        if(newAmount.length == 1) return newAmount[0];
        if(newAmount.length == 2) {
            if(newAmount[0] == newAmount[1]) {
                return newAmount[0];
            } else {
                int max = Math.max(newAmount[0], newAmount[1]);
                int min = Math.min(newAmount[0], newAmount[1]);
                return min + (max - min);
            }  
        }

        newAmount[0] -= 1;
        newAmount[newAmount.length - 1] -= 1;

        return 1 + totalSeconds(newAmount);
        
    
    }

    private static int[] eliminateZeroSort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int num : arr) {
            if(num != 0) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }



 
}



// not the right solution below

        // int seconds = 0;    
        // int totalCups = 0;;
        // int maxIdx = 0;
        // int minIdx = 0;
        // int secMinIdx = 0;


        // for(int i = 0; i < amount.length; i++) {
        //     totalCups += amount[i];
        //     maxIdx = amount[i] > amount[maxIdx] ? i : maxIdx;
        //     if(amount[i] < amount[minIdx]) {
        //         secMinIdx = minIdx;
        //         minIdx = i;
        //     } else {
        //         secMinIdx = i;
        //     }
           
        // }
        // System.out.println("max: " + maxIdx + ", min: " + minIdx + ", secMin: " + secMinIdx);

        // while(totalCups > 0) {
        //     if(amount[maxIdx] != totalCups) {
        //         totalCups -= (amount[minIdx] * 2);
        //         seconds += amount[minIdx];
        //         amount[maxIdx] -= amount[minIdx];
        //         amount[minIdx] = 0;
        //         minIdx = secMinIdx;
                
        //         if(amount[minIdx] > amount[maxIdx]) {
        //             int temp = maxIdx;
        //             maxIdx = minIdx;
        //             minIdx = temp;
        //         }

        //     } else {
        //         totalCups -= amount[maxIdx];
        //         seconds += amount[maxIdx];
        //         amount[maxIdx] = 0;
        //     }
            
        // }

        // return seconds;