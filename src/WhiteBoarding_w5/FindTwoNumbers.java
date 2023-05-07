package WhiteBoarding_w5;

import java.util.Arrays;

// Given an unsorted array of size n. Array elements are in the range of 1 to n. 
// One number from set {1, 2, …n} is missing and one number occurs twice in the array. 
// Find these two numbers.

// Examples: 

//     Input: arr[] = {3, 1, 3}
//     Output: Missing = 2, Repeating = 3
//     Explanation: In the array, 2 is missing and 3 occurs twice 

//     Input: arr[] = {4, 3, 6, 2, 1, 1}
//     Output: Missing = 5, Repeating = 1

public class FindTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 3};
        int[] arr2 = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoNumbers(arr1));
        System.out.println(findTwoNumbers(arr2));

    }

    public static String findTwoNumbers(int[] arr) {
   
        Arrays.sort(arr);
        int missing = 0;
        int repeat = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i-1 >= 0) {
                if(arr[i] == arr[i-1]) repeat = arr[i];
                if(arr[i] - arr[i-1] > 1) missing = arr[i] - 1;
            }
        }

        return "Missing = " + missing + ", Repeat = " + repeat;
    }
}
