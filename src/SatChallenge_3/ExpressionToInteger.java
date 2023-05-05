package SatChallenge_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:
// The valid operators are '+', '-', '', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
 
// Example 1:
// Input: tokens = ["2","1","+","3",""]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

// Example 2:
// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

public class ExpressionToInteger {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("2","1","+","3",""));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("4","13","5","/","+"));

        System.out.println(returnInt(arr1));
        System.out.println(returnInt(arr2));
    }

    public static Integer returnInt(ArrayList<String> arr) {
        // going from left to right, look for operators and the two elements ahead of it
        // replacing the first of the three element with the result, remove the following two elements
        // recursively run the array until we are left with just single element

        if(arr.size() == 1) {
            return Integer.parseInt(arr.get(0));
        }
        List<String> operators = Arrays.asList(new String[]{"+", "-", "/", ""});
       
        
        for(int i = 0; i < arr.size(); i++) {

            if(operators.contains(arr.get(i))) {
                String result = operation(Integer.parseInt(arr.get(i-2)), Integer.parseInt(arr.get(i-1)), arr.get(i));
                arr.set(i-2, result);
                arr.remove(i);
                arr.remove(i-1);
                break;
            }
            
        }

        return returnInt(arr);
    }

    public static String operation(Integer a, Integer b, String operator) {
        switch(operator) {
            case "+":
                return Integer.toString(a + b);
            case "-":
                return Integer.toString(a - b);
            case "/":
                return Integer.toString(a / b);
            case "":
                return Integer.toString(a * b);
            default:
                return null;
        }
    }
}
