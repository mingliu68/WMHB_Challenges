// Problem 3:
//  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:
//     2 <= nums.length <= 104
//     -109 <= nums[i] <= 109
//     -109 <= target <= 109
//     Only one valid answer exists.
 
// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


package WhiteBoarding_w2;

import java.util.Arrays;
import java.util.HashMap;

public class FindTargetSumIndecies {
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        int[] arr3 = {3, 3};

        System.out.println(Arrays.toString(getIndecies(arr1, 9)));
        System.out.println(Arrays.toString(getIndecies(arr2, 6)));
        System.out.println(Arrays.toString(getIndecies(arr3, 6)));

    }

    // int[] arr, int target
    // create a dictionary for seen items and their index
    public static int[] getIndecies(int[] arr, int target) {

        HashMap<Integer, Integer> dictionary = new HashMap<>();

        int[] solution = {-1, -1};

        for(int i = 0; i < arr.length; i++){
            if(dictionary.containsKey(target - arr[i])) {
                solution[0] = dictionary.get(target - arr[i]);
                solution[1] = i;
                return solution;
            }
            dictionary.put(arr[i], i);
        }

        return solution;
    }

}
