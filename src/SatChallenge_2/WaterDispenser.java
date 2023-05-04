package SatChallenge_2;
// You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.

// You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold, warm, and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.

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

        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        int[] c = {5, 0, 0};
        System.out.println(getFill(a));
  
        System.out.println(getFill(b));
        
        System.out.println(getFill(c));
    }

    public static int getFill(int[] array) {
        // keep count, current min and minIndex
        // while all element are not zero
        // keep track of smallest while going over each one of non min value and reduce by one
        
        int count = 0;
        int minIndex = 0;
        int currentMinIndex = 0;
        for(int i = 1; i < array.length; i++) {
            minIndex = array[i] < array[minIndex] ? i : minIndex;
            currentMinIndex = minIndex;
        }

        while(array[0] != 0 || array[1] != 0 || array[2] != 0) {
            minIndex = currentMinIndex;
            
            for(int i = 0; i < array.length; i++) {
                if(i != minIndex && array[i] != 0) {
                    array[i]= array[i]-1;
                    if(array[i] < array[currentMinIndex]) currentMinIndex = i;
                }   
            }
            
            count++;
        }
        return count;
    }
}
