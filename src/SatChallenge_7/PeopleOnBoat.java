package SatChallenge_7;

import java.util.Arrays;
import java.util.HashMap;

/*
You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, 
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.
 

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

 
Constraints:
    1 <= people.length <= 5 * 104
    1 <= people[i] <= limit <= 3 * 104
 */
public class PeopleOnBoat {
    public static void main(String[] args) {
        int[] weight1 = {1, 2};  //1
        int[] weight2 = {3,2,2,1};  //3
        int[] weight3 = {3,5,3,4};  //4

        System.out.println(minBoats(weight1, 3));
        System.out.println(minBoats(weight2, 3));
        System.out.println(minBoats(weight3, 5));


    }

    public static int minBoats(int[] weights, int limit) {
        if(weights.length < 2 && weights[0] <= limit) {
            return 1;
        }
        HashMap<Integer, Integer> weightMap = new HashMap<>();
        int max = 0;
        int count = 0;
        for(int weight : weights) {
            max = weight > max ? weight : max;
            if(weightMap.containsKey(weight)) {
                weightMap.put(weight, weightMap.get(weight)+1);
            } else {
                weightMap.put(weight, 1);
            }
        }
        
        while(!weightMap.isEmpty() && max > 0){
            if(weightMap.containsKey(max)) {
                if (max == limit) {
                    count++;
                    weightMap.put(max, weightMap.get(max) - 1);
                    // if we have exhausted the max 
                    if(weightMap.get(max) == 0) {
                        weightMap.remove(max);
                        max--;
                    }
                } else if(weightMap.containsKey(limit - max)) {
                    count++;
                    weightMap.put(max, weightMap.get(max) - 1);
                    weightMap.put(limit - max, weightMap.get(limit - max) - 1);
                    if(weightMap.get(limit - max) == 0) {
                        weightMap.remove(limit-max);
                    }
                    if(weightMap.get(max) == 0) {
                        weightMap.remove(max);
                        max--;
                    }
                } else {
                   count++;
                   weightMap.put(max, weightMap.get(max) - 1);
                   if(weightMap.get(max) == 0) {
                    weightMap.remove(max);
                    max--;
                   }     
                }
            } else {
                max--;
            }
        }

        return count;
    }
}
