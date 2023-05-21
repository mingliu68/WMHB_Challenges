package SatChallenge_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
 * Please write a program that will put + (2+3), - (3-2), 
 * or nothing ( ) between the digits 9 to 0 (in that order) so that the result is 200 
 * For example: 98+76-5+43-2-10=200. 
 */
public class MathOperation {
    // options are
    // 9 + { 8, 7, 6, 5, 4, 3, 2, 1, 0} 
    // 9 - { 8, 7, 6, 5, 4, 3, 2, 1, 0} 
    // 98 + { 7, 6, 5, 4, 3, 2, 1, 0}
    // 98 - { 7, 6, 5, 4, 3, 2, 1, 0} 

    public static void main(String[] args) {

        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        ArrayList<String> opers = new ArrayList<>();

        System.out.println("Solution: " + solution(arr, 200, opers));


        int[] arr2 = {5,4,3,2,1,0};
        System.out.println("Solution: " + solution(arr2, 10, opers));
    }

    // NOT WORKING
    public static ArrayList<String> solution(int[] arr, int sum, ArrayList<String> operations) {
        
        String lastOperation = operations.size() > 0 ?  operations.get(operations.size() - 1) : null;

        if (arr.length == 0) {
            if (sum == 0) {
                return operations;
            } else {
                return null;
            }
        } else if (arr.length == 1) {
            if(sum == (lastOperation == "+" || lastOperation == null ? arr[0] : arr[0] * -1)) {
                operations.add(String.valueOf(arr[0]));
                return operations;
            }   else {
            return null;
            }
        } else {
            
            int currentSingle = arr[0];
            int currentDouble = arr[0] * 10 + arr[1];
            int newSumSingle = sum - (lastOperation == "+" || lastOperation == null ? currentSingle : currentSingle * -1);
            int newSumDouble = sum - (lastOperation == "+" || lastOperation == null ? currentDouble : currentDouble * -1);
            
            // single digit + 
            ArrayList<String> singlePlus = new ArrayList<>();
            singlePlus.addAll(operations);
            singlePlus.add(String.valueOf(currentSingle));
            singlePlus.add("+");
            System.out.println("Arr : " + singlePlus.toString() + ", Sum: " + newSumSingle);
            ArrayList<String> singlePlusResult = solution(Arrays.copyOfRange(arr, 1, arr.length), newSumSingle, singlePlus);
            if(singlePlusResult != null) return singlePlusResult;
            
            // single digit -
            ArrayList<String> singleMinus = new ArrayList<>();
            singleMinus.addAll(operations);
            singleMinus.add(String.valueOf(currentSingle));
            singleMinus.add("-");
            System.out.println("Arr : " + singleMinus.toString() + ", Sum: " + newSumSingle);
            ArrayList<String> singleMinusResult = solution(Arrays.copyOfRange(arr, 1, arr.length), newSumSingle, singleMinus);
            if(singleMinusResult != null) return singleMinusResult;
            
            
            // double digits +
            ArrayList<String> doublePlus = new ArrayList<>();
            doublePlus.addAll(operations);
            doublePlus.add(String.valueOf(currentDouble));
            doublePlus.add("+");
            System.out.println("Arr : " + doublePlus.toString() + ", Sum: " + newSumDouble);
            
            ArrayList<String> doublePlusResult = solution(Arrays.copyOfRange(arr, 2, arr.length), newSumDouble, doublePlus);
            if(doublePlusResult != null) return doublePlusResult;

            // double digits -
            ArrayList<String> doubleMinus = new ArrayList<>();
            doubleMinus.addAll(operations);
            doubleMinus.add(String.valueOf(currentDouble));
            doubleMinus.add("-");
            System.out.println("Arr : " + doubleMinus.toString() + ", Sum: " + newSumDouble);
            ArrayList<String> doubleMinusResult = solution(Arrays.copyOfRange(arr, 2, arr.length), newSumDouble, doubleMinus);
            if(doubleMinusResult != null) return doubleMinusResult;
        }


        return null;
    }
}
