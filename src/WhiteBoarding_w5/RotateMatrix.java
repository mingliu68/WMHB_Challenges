package WhiteBoarding_w5;

import java.util.Arrays;

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Example 1:
// [[1,2,3],
// [4,5,6],
// [7,8,9]]
//     ->
// [[7,4,1],
// [8,5,2],
// [9,6,3]]
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Example 2:
// [[5,1,9,11],
// [2,4,8,10],
// [13,3,6,7],
// [15,14,12,16]]
// ->
// [[15,13,2,5],
// [14,3,4,1],
// [12,6,8,9],
// [16,7,10,11]]
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

// Constraints:
//     n == matrix.length == matrix[i].length
//     1 <= n <= 20
//     -1000 <= matrix[i][j] <= 1000

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix1 ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        System.out.println(Arrays.deepToString(rotatingMatrix(matrix1)));
        System.out.println(Arrays.deepToString(rotatingMatrix(matrix2)));

        }

    public static int[][] rotatingMatrix(int[][] matrix) {
        if(matrix.length == 1) return matrix;

        int length = matrix.length;
        int depth = matrix.length / 2;

        for(int i = 0; i < depth ; i++) {
            int start = i;
            int end = length - 1 - i;
            for(int j = i; j < end; j++) {

                int temp = matrix[i][j];
                // left to top
                matrix[i][j] = matrix[length - 1 - j][start];

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
}
