package WhiteBoarding_w5;

import java.util.Arrays;

// Given an integer array nums, move all 0's to the end of it while maintaining the 
// relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Example 2:
// Input: nums = [0]
// Output: [0]


// Constraints:
//     1 <= nums.length <= 104
//     -231 <= nums[i] <= 231 - 1

public class ShiftingZeros {
    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        int[] nums3 = {0,0};
        int[] nums4 = {1,0,0,0,1,1,0,0,1,1,1,1};

        System.out.println(Arrays.toString(shiftingZeros(nums1)));
        System.out.println(Arrays.toString(shiftingZeros(nums2)));
        System.out.println(Arrays.toString(shiftingZeros(nums3)));        
        System.out.println(Arrays.toString(shiftingZeros(nums4)));

    }

    public static int[] shiftingZeros(int[] nums) {
        if(nums.length == 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int count = 1;
                while(i + count < nums.length) {
                    if(nums[i+count] != 0) {
                        nums[i] = nums[i+count];
                        nums[i+count] = 0;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return nums;
    }
}


