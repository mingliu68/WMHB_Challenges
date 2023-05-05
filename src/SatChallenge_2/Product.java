package SatChallenge_2;

import java.util.Arrays;

// Given an integer array nums, return an array answer such that answer[i] is equal to the 
// product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// Constraints:
//     2 <= nums.length <= 105
//     -30 <= nums[i] <= 30
//     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count a

public class Product {
    public static void main(String[] args) {
        
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        System.out.println(Arrays.toString(getProduct(nums1)));
        System.out.println(Arrays.toString(getProduct(nums2)));
    }

    public static int[] getProduct(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftside = new int[nums.length];
        int[] rightside = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0)  
            {
                leftside[i] = nums[i];
                rightside[nums.length - 1 - i] = nums[nums.length - 1 - i];
            }
            else {
                leftside[i] = nums[i] * leftside[i-1];
                rightside[nums.length - 1 - i] = nums[nums.length - 1 - i] * rightside[nums.length - 1 - (i - 1)];
            }
        }

        // for(int i = 0; i < nums.length; i++) {
        //     if(i == 0) {
        //         leftside[i] = nums[i];
        //     } else {
        //         leftside[i] = nums[i] * leftside[i-1];
        //     }
        // }

        // for(int i = nums.length - 1; i >= 0; i--) {
        //     if(i == nums.length - 1) {
        //         rightside[i] = nums[i];
        //     } else {
        //         rightside[i] = nums[i] * rightside[i + 1];
        //     }
        // }

        System.out.println("leftside: " + Arrays.toString(leftside));
        System.out.println("rightside: " + Arrays.toString(rightside));

        for(int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                result[i] = rightside[i+1];
            } else if (i + 1 >= nums.length) {
                result[i] = leftside[i-1];
            } else {
                result[i] = leftside[i-1] * rightside[i+1];
            }
        }
        return result;
    }
    

}
