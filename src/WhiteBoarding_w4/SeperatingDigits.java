package WhiteBoarding_w4;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of positive integers nums, return an array answer 
// that consists of the digits of each integer in nums after separating 
// them in the same order they appear in nums.

// To separate the digits of an integer is to get all the digits it has in the same order.

// For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
 

// Example 1:

// Input: nums = [13,25,83,77]
// Output: [1,3,2,5,8,3,7,7]
// Explanation: 
// - The separation of 13 is [1,3].
// - The separation of 25 is [2,5].
// - The separation of 83 is [8,3].
// - The separation of 77 is [7,7].
// answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
// Example 2:

// Input: nums = [7,1,3,9]
// Output: [7,1,3,9]
// Explanation: The separation of each integer in nums is itself.
// answer = [7,1,3,9].
 

// Constraints:

// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 105

public class SeperatingDigits {
    public static void main(String[] args) {
        int[] nums1 = {13,25,83,77};
        int[] nums2 = {7,1,3,9};
        int[] nums3 = {152,326,313,92};

        System.out.println(Arrays.toString(seperatingDigits(nums1)));
        System.out.println(Arrays.toString(seperatingDigits(nums2)));
        System.out.println(Arrays.toString(seperatingDigits(nums3)));
    }

    public static int[] seperatingDigits(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(nums[i] / 10 > 0) {
                result.add(0, nums[i] % 10);
                nums[i] = nums[i] / 10;
            }
            result.add(0, nums[i]);
        }

        int[] resultArr = result.stream().mapToInt(i -> i).toArray();
        return resultArr;
    }
}
