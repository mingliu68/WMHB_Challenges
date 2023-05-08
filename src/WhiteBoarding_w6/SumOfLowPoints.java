package WhiteBoarding_w6;


// Given a 2-dimensional array of numbers (i.e. an array of arrays), write a function
//   that returns the sum of all numbers that are *low points*. A low point is any
//   number that is smaller than its neighbors above, below, and to the left and right.
//   Example:

//  Int[][] a ={    {9, 8, 6, 5, 4},    
//                  {7,`4`,7, 7,`2`},    
//                  {6, 5,`0`,5, 6},
//                  {3,`1`,8, 5, 8}}

//  The ‘ ‘ numbers are low points, so the function should return 4 + 2 + 0 + 1 = 7.

// Hint: The trick to this problem is making sure indices do not go out of bounds.

public class SumOfLowPoints {
    public static void main(String[] args) {
        int[][] a = {
                    {9,8,6,5,4},    
                    {7,4,7,7,2},    
                    {6,5,0,5,6},
                    {3,1,8,5,8}};
        System.out.println(getSumOfLowPoints(a));
    }
    public static int getSumOfLowPoints(int[][] matrix) {
        int result = 0;
        boolean top;
        boolean bottom;
        boolean left;
        boolean right;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                top = i-1 < 0 ? true : matrix[i-1][j] > matrix[i][j] ? true : false;
                bottom = i+1 >= matrix.length ? true : matrix[i+1][j] > matrix[i][j] ? true : false;
                left = j-1 < 0 ? true : matrix[i][j-1] > matrix[i][j] ? true : false;
                right = j+1 >= matrix[0].length ? true : matrix[i][j+1] > matrix[i][j] ? true : false;
                
                result = top && bottom && left && right ? result + matrix[i][j] : result;
            }
        }
        return result;
    }
}
