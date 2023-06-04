package WhiteBoarding_w15;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array nums with n objects colored red, white, or blue, 
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
 
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */
public class RedWhiteBlue {
    public static void main(String[] args) {
        int[] colors1 = {2,0,2,1,1,0};
        int[] colors2 = {2,0,1};

        System.out.println(Arrays.toString(sortColorHash(colors1)));
        System.out.println(Arrays.toString(sortColorHash(colors2)));

    }

    public static int[] sortColorHash(int[] arr) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        // O(n) creating colorMap
        for(int color : arr) {
            if(colorMap.containsKey(color)) {
                colorMap.put(color, colorMap.get(color) + 1);
            } else {
                colorMap.put(color, 1);
            }
        }
        int key = 0; 
        int idx = 0;
        // O(n) iterate colormap
        while(key <= 2) {
            if(colorMap.containsKey(key)) {
                arr[idx] = key;
                idx++;
                colorMap.put(key, colorMap.get(key) - 1);
                if(colorMap.get(key) == 0) {
                    colorMap.remove(key);
                }
            } else {
                key++;
            }
        }
        return arr;
    }
}
