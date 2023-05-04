package WhiteBoarding_w7;

import java.util.HashMap;

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
// according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

// input =>
// {5, 3, 0, 0, 7, 0, 0, 0, 0}
// {6, 0, 0, 1, 9, 5, 0, 0, 0}
// {0, 9, 8, 0, 0, 0, 0, 6, 0}
// {8, 0, 0, 0, 6, 0, 0, 0, 3}
// {4, 0, 0, 8, 0, 3, 0, 0, 1}
// {7, 0, 0, 0, 2, 0, 0, 0, 6}
// {0, 6, 0, 0, 0, 0, 2, 8, 0}
// {0, 0, 0, 4, 1, 9, 0, 0, 5}
// {0, 0, 0, 0, 8, 0, 0, 7, 9}

// Arrays.asList().contains()


public class ValidSudoku {
    public static void main(String[] args) {
        Integer[][] matrix1 = new Integer[][]
        {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        Integer[][] matrix2 = new Integer[][]
        {
            {8, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(checkValidSudoku(matrix1));
        System.out.println(checkValidSudoku(matrix2));
    }

    public static Boolean checkValidSudoku(Integer[][] matrix) {

        // creating seen hashmap to keep track of seen item in each {row,col,square}
        HashMap<Integer,String[]> seen = new HashMap<>();
        for(int i = 1; i <= 9; i++) {
            seen.put(i, new String[]{"", "", ""});
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                String[] current = seen.get(matrix[i][j]);

                if (matrix[i][j] != 0) {
                    // check for row
                    if(current[0] != "r" + Integer.toString(i)){
                        current[0] = "r" + Integer.toString(i);
                    } else {
                        return false;
                    }
                    // check for col
                    if(current[1] != "c" + Integer.toString(j)) {
                        current[1] = "c" + Integer.toString(j);
                    } else {
                        return false;
                    }
                    // check for square
                    if(current[2] != getSquare(i, j)) {
                        current[2] = getSquare(i, j);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String getSquare(int row, int col) {

        if(row <= 2) {
            if(col <= 2) return "s1";
            else if(col <= 5) return "s2";
            else if(col <= 8) return "s3";
        } else if (row <= 5) {
            if(col <= 2) return "s4";
            else if(col <= 5) return "s5";
            else if(col <= 8) return "s6";
        } else if (row <= 8) {
            if(col <= 2) return "s7";
            else if(col <= 5) return "s8";
            else if(col <= 8) return "s9";
        }
        return null;

    }
}
