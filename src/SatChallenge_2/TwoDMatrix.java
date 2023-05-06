package SatChallenge_2;

import java.util.Arrays;

/* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
[[1,2,3],
[4,5,6],
[7,8,9]]
    ->
[[7,4,1],
[8,5,2],
[9,6,3]]
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
[[5,1,9,11],
[2,4,8,10],
[13,3,6,7],
[15,14,12,16]]
->
[[15,13,2,5],
[14,3,4,1],
[12,6,8,9],
[16,7,10,11]]
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

[i][j] => [cols-i][row]
[0][1] => [4-1][1]

Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
*/


public class TwoDMatrix {   
    public static void main(String[] args) {
        
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        int[][] matrix3 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix4 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};

        System.out.println(Arrays.deepToString(rotateMatrix_Transpose(matrix1)));
        System.out.println(Arrays.deepToString(rotateMatrix_Transpose(matrix2)));
        System.out.println(Arrays.deepToString(rotateMatrix(matrix3)));
        System.out.println(Arrays.deepToString(rotateMatrix(matrix4)));
    }


    // solution rotating
    public static int[][] rotateMatrix(int[][] matrix) {

        int length = matrix.length;
        int depth = length / 2;

        // start with each layer deep
        for(int i = 0; i < depth; i++) {
            int start = i;
            int end = length - 1 - i;
            
            // length - 1 - i because we only need to rotate up to the one to last cell
            // as the last cell has already been replaced by the first one in row 
            for(int j = i; j < length - 1-i; j++) {

                int temp = matrix[start][j];

                // left to top
                matrix[start][j] = matrix[length - 1 - j][start];

                // bottom to left
                matrix[length - 1 - j][start] = matrix[end][length - 1 - j];

                // right to bottom
                matrix[end][length - 1 - j] = matrix[j][end];

                // top to right
                matrix[j][end] = temp;

            }
        }

        return matrix;
    }


    // solution using transpose & reversing
    public static int[][] rotateMatrix_Transpose(int[][] matrix) {
        // rotating matrix result looks like transpose matrix (row to col, col to row), but in reversing order
        // transpose, then reverting order

        int length = matrix.length;

        // transposing matrix
        for(int i = 0; i < length; i++) {
            // j start at i value, transposing matrix diagonally
            for(int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reversing order

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }

        return matrix;
    }


}
