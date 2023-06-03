package SatChallenge_7;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0
 */
public class Astroids {
    public static void main(String[] args) {
        int[] asteroids1 = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10,2,-5};
        int[] asteroids4 = {5,3,1,-4,-7,3}; 
        // 5,3,-4,-7,3 
        // 5, -4,-7,3 
        // 5, -7, 3 
        // -7,3  
        // -7
        System.out.println(Arrays.toString(results(asteroids1)));
        System.out.println(Arrays.toString(results(asteroids2)));
        System.out.println(Arrays.toString(results(asteroids3))); 
        System.out.println(Arrays.toString(results(asteroids4))); 


    }

    public static int[] results(int[] array) {
        ArrayList<Integer> asteroids = new ArrayList<>();
        for(int num : array) asteroids.add(num);
        Boolean hasCollided = true;

        while(hasCollided && asteroids.size() > 1) {
            hasCollided = false;
            for(int i = 0; i < asteroids.size() - 1; i++) {
                
                if((asteroids.get(i) + asteroids.get(i+1)) < Math.max(asteroids.get(i), asteroids.get(i+1)) ) {
                    if(Math.abs(asteroids.get(i)) == Math.abs(asteroids.get(i+1))) {
                        asteroids.remove(i+1);
                        asteroids.remove(i);
                    }
                    else if(Math.abs(asteroids.get(i)) < Math.abs(asteroids.get(i+1))) {
                        asteroids.remove(i);
                    } 
                    else {
                        asteroids.remove(i+1);
                    }
                    hasCollided = true;
                }
            }
        }
        
        int[] result = asteroids.stream().mapToInt(i -> i).toArray();

        return result;
    }
}
