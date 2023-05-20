package WhiteBoarding_w7;

import java.util.ArrayList;
import java.util.Arrays;

// input =>  [0, 1, 1, 0, 0]
//           [0, 0, 0, 0, 1]
//           [1, 0, 1, 1, 1]
//           [0, 0, 0, 0, 1]
//           [0, 1, 1, 0, 0]
//           start => [0, 0]
//           end => [4, 4]

public class FindPath {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0}
        };
        int[][] matrix2 = {
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 0}
        };
        ArrayList<Integer[]> tempPath = new ArrayList<Integer[]>();
        // path is an array of array {{0,0}, {1,0}, {1,1}, ....}
        ArrayList<Integer[]> path = getPath(0, 0, 0, 0, tempPath, matrix2);
        for(Integer[] step : path) {
            System.out.println(Arrays.toString(step));
        }
    }

    public static ArrayList<Integer[]> getPath(int prevR, int prevC, int currentR, int currentC, ArrayList<Integer[]> currentPath, int[][] matrix) {
        // if (
        //     currentR < 0 || 
        //     currentC < 0 || 
        //     currentR > matrix.length - 1 || 
        //     currentC > matrix[0].length - 1 || 
        //     matrix[currentR][currentC] == 1 ) 
        // {
        //     return null;
        // }     
        
        // is the current position already visited in the past in current path
        for(Integer[] position : currentPath) {
            if(position[0] == currentR && position[1] == currentC) {
                return null;
            }
        }

        currentPath.add(new Integer[]{currentR, currentC});

        if(currentR == matrix.length - 1 && currentC == matrix[0].length - 1) {
            return currentPath;
        }

        // check for neighboring cell

        // top
        if(currentR - 1 != prevR && currentR - 1 >= 0 && matrix[currentR-1][currentC] != 1) {
           ArrayList<Integer[]> updatedPath = new ArrayList<>(currentPath);
           ArrayList<Integer[]> result = getPath(currentR, currentC, currentR-1, currentC,updatedPath, matrix);
           if (result != null) return result;
        }

        // left
        if(currentC - 1 != prevC && currentC - 1 >= 0 && matrix[currentR][currentC-1] != 1) {
            ArrayList<Integer[]> updatedPath = new ArrayList<>(currentPath);
            ArrayList<Integer[]> result = getPath(currentR, currentC, currentR, currentC-1, updatedPath, matrix);
            if (result != null) return result;
        }

        // right
        if(currentC + 1 != prevC && currentC + 1 < matrix[0].length && matrix[currentR][currentC+1] != 1) {
            ArrayList<Integer[]> updatedPath = new ArrayList<>(currentPath);
            ArrayList<Integer[]> result = getPath(currentR, currentC, currentR, currentC+1, updatedPath, matrix);
            if (result != null) return result;
        }
        
        // bottom
        if(currentR + 1 != prevR && currentR + 1 < matrix.length && matrix[currentR+1][currentC] != 1) {
            ArrayList<Integer[]> updatedPath = new ArrayList<>(currentPath);
            ArrayList<Integer[]> result = getPath(currentR, currentC, currentR+1, currentC, updatedPath, matrix);
            if (result != null) return result;
        }

        return null;
    }

}
