package WhiteBoarding_w5;

import java.util.HashMap;

// Given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
// return the minimum integer common to both arrays. If there is no common 
// integer amongst nums1 and nums2, return -1.

// Note that an integer is said to be common to nums1 and nums2 if both 
// arrays have at least one occurrence of that integer.

// Example 1:
// Input: nums1 = [1,2,3], nums2 = [2,4]
// Output: 2
// Explanation: The smallest element common to both arrays is 2, so we return 2.

// Example 2:
// Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
// Output: 2
// Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.

// Constraints:
//     1 <= nums1.length, nums2.length <= 105
//     1 <= nums1[i], nums2[j] <= 109
//     Both nums1 and nums2 are sorted in non-decreasing order.

public class CommonInteger {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        int[] nums3 = {1,2,3,6};
        int[] nums4 = {4,5,7,8};

        System.out.println(getMinimumCommon(nums1, nums2));
        System.out.println(getMinimumCommon(nums3, nums4));

    }

    public static int getMinimumCommon(int[] nums1, int[] nums2) {
        if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0]) return -1;

        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            seen.put(nums1[i], i);
        }
        for(Integer num : nums2) {
            if(seen.containsKey(num)) return num;
        }
        return -1;
    }
}
