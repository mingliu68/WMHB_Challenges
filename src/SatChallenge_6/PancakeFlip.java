package SatChallenge_6;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

Example 1:
Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
Example 2:

Input: arr = [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 
Constraints:
1 <= arr.length <= 100
1 <= arr[i] <= arr.length
All integers in arr are unique (i.e. arr is a permutation of the integers from 1 to arr.length).
 */

public class PancakeFlip {
    public static void main(String[] args) {
        int[] arr1 = { 3, 2, 4, 1 };
        int[] arr2 = { 5, 7, 4, 8, 2, 2, 5, 4, 2, 11, 19, 2, 3};
        System.out.println(solution(arr1));
        System.out.println(Arrays.toString(arr1));
        System.out.println(solution(arr2));
        System.out.println(Arrays.toString(arr2));
    }
    
    public static ArrayList<Integer> solution(int[] arr) {
        int k = arr.length;
        int currMax = arr.length;
        ArrayList<Integer> flips = new ArrayList<>();
        // find the max idx, and use max idx + 1 as k
        
        while(currMax > 0) {
            // get max indexint 
            int foundMaxIdx = getMaxIdx(arr, currMax);    
            
            if(foundMaxIdx == currMax - 1) {
                currMax--;
                continue;
            } else {
                k = foundMaxIdx + 1;
            }
            // move max to beginning
            pancakeFlipArr(arr, k);
            flips.add(k);
            // move max to end of subarray
            pancakeFlipArr(arr, currMax);
            flips.add(currMax);
            currMax--;
        }

        return flips;

    }

    public static int[] pancakeFlipArr(int[] arr, int k) {
        for(int i = 0; i < k / 2; i++ ) {
            int temp = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp;
        }
        return arr;
    }

    public static int getMaxIdx(int[] arr, int k) {
        if(arr.length == 1) return 1;
        int maxIdx = 0;
        for(int i = 0; i < k; i++) {
            maxIdx = arr[i] > arr[maxIdx] ? i : maxIdx;
        }
        return maxIdx;
    }
}
