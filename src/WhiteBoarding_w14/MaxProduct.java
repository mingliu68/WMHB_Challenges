package WhiteBoarding_w14;
/*
 * Given an integer array nums, find three numbers whose product is maximum 
 * and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6

Constraints:
    3 <= nums.length <= 104
    -1000 <= nums[i] <= 1000
 */
public class MaxProduct {
    
    public static void main(String[] args) {
        
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {-1,-2, -3};
        int[] arr4 = {-1, 2, -3, 4, -5};

        System.out.println(maxProduct(arr1));
        System.out.println(maxProduct(arr2));
        System.out.println(maxProduct(arr3));
        System.out.println(maxProduct(arr4));

    }

    public static int maxProduct (int[] arr) {
        // loop from 0 to arr.length - 3 (includisve)
        int max = -1000*-1000*-1000;
        // n = arr.length, m = sol.length 
        // O(n x m)
        for(int i = 0; i <= arr.length - 3; i++) {
            int currProduct = arr[i];
            for(int j = 1; j < 3; j++) {
                currProduct *= arr[i+j];
            }
            if(currProduct > max) {
                max = currProduct;
            }
        }
        return max;
    }
}
