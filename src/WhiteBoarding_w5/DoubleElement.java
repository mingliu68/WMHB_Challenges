package WhiteBoarding_w5;

import java.util.HashMap;


// Given an array arr of integers, check if there exist two indices i and j such that :

//     i != j
//     0 <= i, j < arr.length
//     arr[i] == 2 * arr[j]

// Example 1:
// Input: arr = [10,2,5,3]
// Output: true
// Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

// Example 2:
// Input: arr = [3,1,7,11]
// Output: false
// Explanation: There is no i and j that satisfy the conditions.

// Constraints:
//     2 <= arr.length <= 500
//     -103 <= arr[i] <= 103

public class DoubleElement {
    public static void main(String[] args) {
        int[] arr1 = {10,2,5,3};
        int[] arr2 = {3,1,7,11};

        System.out.println(hasDoubleElement(arr1));
        System.out.println(hasDoubleElement(arr2));

    }

    public static boolean hasDoubleElement(int[] arr) {
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for(int num : arr) {
            if(seen.containsKey(num * 2)) return true;
            seen.put(num, true);
        }
        return false;
    }
}
