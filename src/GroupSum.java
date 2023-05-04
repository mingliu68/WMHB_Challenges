import java.util.Arrays;
import java.util.List;

public class GroupSum {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 3, 10};
        System.out.println(groupSum(arr1, 8));
        // System.out.println(arr1[0]);
    }

    public static boolean groupSum(int[] arr, int target) {
        if(arr.length < 1) {
            return false;
        }
        else if(arr.length == 1 && arr[0] == target) {
            return true;
        }
        else {
            return getToZero(target, arr);
        }
    }

    public static boolean getToZero(int target, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return true;
            } else if(arr[i] < target){
                if(i == 0 && arr.length > 1) {
                    return getToZero(target - arr[i] , Arrays.copyOfRange(arr, 1, arr.length));
                } else if(i == arr.length-1) {
                    return getToZero(target-arr[i], Arrays.copyOfRange(arr, 0, arr.length-1 ));
                } else {
                    int[] arr1 = Arrays.copyOfRange(arr, 0, i);
                    int[] arr2 = Arrays.copyOfRange(arr, i+1, arr.length);
                    int[] newArr = ArraysUtils.addAll(arr1, arr2);
                    return getToZero(target - arr[i], newArr);
                }
                
            }
        }
        
        return false;
    }
}
