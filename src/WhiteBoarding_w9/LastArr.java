package WhiteBoarding_w9;

import java.util.ArrayList;

// You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:

//     Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
//     Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
//     Keep repeating the steps again, alternating left to right and right to left, until a single number remains.

// Given the integer n, return the last number that remains in arr.

// Example 1:
// Input: n = 9
// Output: 6
// Explanation:
// arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
// arr = [2, 4, 6, 8]
// arr = [2, 6]
// arr = [6]

// Example 2:
// Input: n = 1
// Output: 1

// Constraints:
//     1 <= n <= 109

public class LastArr {
    public static void main(String[] args) {
        System.out.println(lastArr(9)); 
    }


  // for every pass, create a new arraylist for newly reduced array
  // counter start at 1, at odd count (left to right), remove at all even
  // including 0, at even count (right to left), remove all length - odd (starting
  // from last item), until length - odd is less than 0
  // repeating until the resulting array is at length = 1

  public static int lastArr(int n) {
    // Integer[] initialArray = IntStream.range(1, n).toArray();

    ArrayList<Integer> arr = new ArrayList<>();

    for (Integer i = 0; i < n; i++) {
      arr.add(i + 1);
    }
    int counter = 1;

    while (arr.size() > 1) {
      ArrayList<Integer> newArr = new ArrayList<>();
      if (counter % 2 != 0) {
        for (int i = 0; i < arr.size(); i++) {
          if (i % 2 != 0) {
            newArr.add(arr.get(i));
          }
        }
      } else {
        for (int i = arr.size()-2; i >= 0; i-=2) {
            newArr.add(0, arr.get(i));
        }
      }
      arr = newArr;
      System.out.println(arr);
      counter++;
    }

    return arr.get(0);
  }
}
