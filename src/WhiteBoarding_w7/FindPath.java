package WhiteBoarding_w7;

import java.util.ArrayList;

// input =>  [0, 1, 1, 0, 0]
//           [0, 0, 0, 0, 1]
//           [1, 0, 1, 1, 1]
//           [0, 0, 0, 0, 1]
//           [0, 1, 1, 0, 0]
//           start => [0, 0]
//           end => [4, 4]

public class FindPath {

    public static void main(String[] args) {
        Integer[][] matrix = {
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0}
        };

        // path is an array of array {{0,0}, {1,0}, {1,1}, ....}
        ArrayList<Integer[]> path = new ArrayList<>();
    }

    public static ArrayList<Integer[]> getPath(int currentR, int currentC, int endR, int endC, ArrayList<Integer[]> currentPath, ArrayList<ArrayList<Integer>> matrix) {
        Integer[] newStep = {currentR, currentC};
        currentPath.add(newStep);
        if(currentR == endR && currentC == endC) {
            return currentPath;
        }
        // look for surrounding and find 0s, then find path recursively until it hits end coordinate

        // top
        if(currentR > 0 && matrix[currentR - 1][currentC] != 1) {
            
            getPath(currentR-1, currentC, endR, endC, currentPath, matrix);
        }

        // bottom

        // left

        // right


        return null;
    }

}
