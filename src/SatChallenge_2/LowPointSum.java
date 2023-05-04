package SatChallenge_2;

// Given a 2-dimensional array of numbers (i.e. an array of arrays), write a function
//   that returns the sum of all numbers that are *low points*. A low point is any
//   number that is smaller than its neighbors above, below, and to the left and right.
//   Example:

//  Int[][] a ={    {9, 8, 6, 5, 4},    
//         {7,`4`,7, 7,`2`},    
//         {6, 5,`0`,5, 6},
//         {3,`1`,8, 5, 8}}

//  The ‘ ‘ numbers are low points, so the function should return 4 + 2 + 0 + 1 = 7.

// Hint: The trick to this problem is making sure indices do not go out of bounds.

public class LowPointSum {
    public static void main(String[] args) {
        int[][] a ={{9, 8, 6, 5, 4},    
                    {7,4,7, 7,2},    
                    {6, 5,0,5, 6},
                    {3,1,8, 5, 8}};

        System.out.println(getLowestSum(a));
    }

    public static int getLowestSum(int[][] array) {
        // loop thru array , keep track of row 
        // each item check for all 4 position within bound

        Boolean isLowest = true;
        int sum = 0;
        for(int r = 0; r < array.length; r++) {
            for(int i = 0; i < array[r].length; i++) {
                
                isLowest = true;
                // check for top
                if(r > 0 && array[r-1][i] <= array[r][i]) isLowest = false;
                // check for bottom
                if(r + 1 < array.length && array[r+1][i] <= array[r][i]) isLowest = false;
                // check for left
                if(i > 0 && array[r][i-1] <= array[r][i]) isLowest = false;
                // check for right
                if(i+1 < array[r].length && array[r][i+1] <= array[r][i]) isLowest = false;

                sum = isLowest ? sum + array[r][i] : sum;
            }
        }

        return sum;
    }

    
}
