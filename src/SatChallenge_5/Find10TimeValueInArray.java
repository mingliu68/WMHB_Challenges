package SatChallenge_5;
 /*
  * 
  Given an array of ints, compute recursively if the array contains somewhere a 
  value followed in the array by that value times 10. We'll use the convention of 
  considering only the part of the array that begins at the given index. 
  In this way, a recursive call can pass index+1 to move down the array.
  The initial call will pass in index as 0.

    array220([1, 2, 20], 0) → true
    array220([3, 30], 0) → true
    array220([3], 0) → false
  */
public class Find10TimeValueInArray {
    
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 20};
        int[] arr2 = {3, 30};
        int[] arr3 = {3};
        int[] arr4 = {5, 2, 3, 7, 20, 200};
        System.out.println(array220(arr1, 0));
        System.out.println(array220(arr2, 0));
        System.out.println(array220(arr3, 0));
        System.out.println(array220(arr4, 0));

    }

    public static boolean array220(int[] arr, int idx) {
        if(idx >= arr.length - 1) return false;

        if(arr[idx + 1] == arr[idx] * 10) return true;

        return array220(arr, idx + 1);
     }


}
