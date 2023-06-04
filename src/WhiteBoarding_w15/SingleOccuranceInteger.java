package WhiteBoarding_w15;

import java.util.HashMap;

/*
 * Given an array of integers A, return the largest integer that only occurs once.

If no integer occurs once, return -1.

Example 1:
Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: 
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.

Example 2:
Input: [9,9,8,8]
Output: -1
Explanation: 
There is no number that occurs only once.
 
Note:
1 <= A.length <= 2000
0 <= A[i] <= 1000
 */
public class SingleOccuranceInteger {
    public static void main(String[] args) {
        int[] nums1 = {5,7,3,9,4,9,8,3,1};
        int[] nums2 = {9,9,8,8};

        System.out.println(getMaxOnce(nums1));
        System.out.println(getMaxOnce(nums2));
    }

    public static int getMaxOnce(int[] arr) {
        int[] max = new int[1];
        max[0] = -1;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : arr) {
            if(map.containsKey(num)) {
                map.put(num, false);
            } else {
                map.put(num, true);
            }
        }
        
        map.forEach((key, value) -> {
            if(value && key > max[0]) setterHelper(key, max); 
        });

        return max[0];
    }

    private static void setterHelper(int newMax, int[] max) {
        max[0] = newMax;
    }   
}
