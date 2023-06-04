package WhiteBoarding_w15;

import java.util.Arrays;

/*
 * Given an m x n integer matrix matrix, if an element is 0, 
 * set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = [ [1,1,1],
                  [1,0,1],
                  [1,1,1]]

Output: [ [1,0,1],
          [0,0,0],
          [1,0,1]]

Example 2:

Input: matrix = [ [0,1,2,0],
                  [3,4,5,2],
                  [1,3,1,5]]

Output: [ [0,0,0,0],
          [0,4,5,0],
          [0,3,1,0]]

 

Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1
 */
public class MatrixToZero {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int[][] matrix2 = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        
        setToZero(matrix1);
        setToZero(matrix2);
    }


    public static int[][] setToZero(int[][] matrix) {
        // space O(mn)
        Boolean[][] isZero = new Boolean[matrix.length][matrix[0].length];
        // O(mn)
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                isZero[i][j] = matrix[i][j] == 0 ? true : false;
            }
        }
        
        // O(mn)
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(isZero[i][j]) {
                    Arrays.fill(matrix[i], 0);
                    // O(m)
                    for(int[] row : matrix) {
                        row[j] = 0;
                    }
                }
            }
        }

        System.out.println();
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row)); 
        }
        System.out.println();

        return matrix;
    }

    public static int[][] setToZero_old(int[][] matrix) {
        
        // creating another matrix of Booleans to keep track if the original is 0 or not
        Boolean[][] isZero = new Boolean[matrix.length][matrix[0].length];
        for(Boolean[] row : isZero) {
            Arrays.fill(row, null);
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // if isZero[i][j] is null means the cell hasn't been visited nor altered
                // set isZero[i][j] true/false to if the current cell is zero or not
                if (isZero[i][j] == null) isZero[i][j] = matrix[i][j] == 0 ? true : false;
                // if current cell is 0 and is originally 0 (isZero[i][j] is true), do row and column operation
                if (matrix[i][j] == 0 && isZero[i][j]) {
                    // column operation
                    int count = 0;
                    while( count < matrix[0].length) {
                        if(isZero[i][count] == null) isZero[i][count] = matrix[i][count] == 0 ? true : false;
                        matrix[i][count] = 0;
                        count++;
                    }
                    count = 0;
                    // row operation
                    while(count < matrix.length) {
                        if(isZero[count][j] == null) isZero[count][j] = matrix[count][j] == 0 ? true : false;
                        matrix[count][j] = 0;
                        count++;
                    }
                }
            }
        }
        System.out.println();
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row)); 
        }
        System.out.println();
        return matrix;
    }
}
