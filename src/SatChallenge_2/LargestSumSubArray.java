package SatChallenge_2;

// Given an integer array nums, find the
// subarray
// with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.

// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 

// Constraints:

//     1 <= nums.length <= 105
//     -104 <= nums[i] <= 104

public class LargestSumSubArray {
    public static void main(String[] args) {
        int[] arr1 = {5,4,-1,7,8};
        int[] arr2 = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(largestSum(arr1));
        System.out.println(largestSum(arr2));

    }

// 5 [5, 9, 8, 15, 23]
// [23 ,18, 14,15,8]   
// [-2, 1, -3, 4,  -1, 2 ,1, -5, 4]

// [-2, -1, -4, 0, -1, 1, 2, -3, 1]
// [0 , 4,5,4 ,2 ,5]

// keep track of largest to begin with i=0 largest 5
// current running sum
// start = 0
// end = 0

// loop thru array from i = 1

// if (num[i] * current > largest)
// then up start to current i
// and update current running sum current sum *= current number

// if not, then move both start and end to i and current sum = num[i];

// loop thru array from i = 1
// largest, firstIndex, running;

// if running + nums[i] >= running
    // running = running + nums[i]
    // largest = running
// if running + nums[i] < running
    // compare nums[firstIndex] and nums[i] and select the larger one


public static int largestSum(int[] nums) {
    if(nums.length == 1) return nums[0];
    int largest = nums[0];
    
    return largest;
}
}
