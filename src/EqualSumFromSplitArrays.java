import java.util.ArrayList;

public class EqualSumFromSplitArrays {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(3);
        array.add(6);
        // array.add(7);
        // array.add(8);

        System.out.println(checkEqual(array)); 
    }   

    public static Boolean checkEqual(ArrayList<Integer> array) {
        int sum = 0;
        for(int num: array) {
            sum += num;
        }
        if (sum % 2 != 0 || array.size() <= 1) {
            return false;
        } else {
            return getToZero(sum/2, array);
        }
    }

    public static Boolean getToZero(int targetSum, ArrayList<Integer> arr) {
        
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == targetSum) {
                return true;
            } else if(arr.get(i) < targetSum) {
                arr.remove(i);
                return getToZero(targetSum - arr.get(i), arr);
            }
        }

        return false;

    }
}

