package SatChallenge_5;
/*
int[] nums, k
Return true if there exists a contiguous subarray within nums whose elements sum to k.

{1, 2, 3, 4, 5} k = 5

base cases 
{} false
{k} true or {i} false
{2, 3} true else continue 


 */

import java.util.Arrays;

public class IsK {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5, 7, 8, 2, 3, 2, 20};
        //System.out.println(followedBy10TimesVal(arr)); 
    
        System.out.println(isKStarter(arr, 300));
      }
    
   
      public static boolean isKStarter(int[] arr, int k) {
        int sum = 0; 
        for(int num : arr) {
          sum += num;
        }
        return isK(arr, k, sum);
      } 
    
      public static boolean isK(int[] arr, int k, int sum) {
        // System.out.println(Arrays.toString(arr));
        if (arr.length == 0) return false;
        if (arr.length == 1) return arr[0] == k;
        if(sum == k) return true;
    
        return (isK(Arrays.copyOfRange(arr, 1, arr.length), k, sum - arr[0]) || isK(Arrays.copyOfRange(arr, 0, arr.length-1), k, sum - arr[arr.length-1]));
      }
}
