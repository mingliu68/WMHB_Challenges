package WhiteBoarding_w7;


// There is a city composed of n x n blocks, where each block contains a single building shaped 
// like a vertical square prism. You are given a 0-indexed n x n integer matrix grid where 
// grid[r][c] represents the height of the building located in the block at row r and column c.

// A city's skyline is the the outer contour formed by all the building when viewing the side 
// of the city from a distance. The skyline from each cardinal direction north, east, south, 
// and west may be different.

// We are allowed to increase the height of any number of buildings by any amount (the amount 
// can be different per building). The height of a 0-height building can also be increased. 
// However, increasing the height of a building should not affect the city's skyline from any 
// cardinal direction.

// Return the maximum total sum that the height of the buildings can be increased by 
// without changing the city's skyline from any cardinal direction.

// Example 1:
// Input: grid = [
// [1,2,1],
// [2,0,0],
// [3,0,0],]

// Output: = 7
// gridNew = [
// [2,2,1],
// [2,2,1],
// [3,2,1],]

// Example 1:
// Input: grid = [
// [3,0,8,4],
// [2,4,5,7],
// [9,2,6,3],
// [0,3,1,0]]

// Output: 35
// gridNew = [ [8, 4, 8, 7],
//             [7, 4, 7, 7],
//             [9, 4, 8, 7],
//             [3, 3, 3, 3] ]

// Example 2:
// Input: grid = [[0,0,0],[0,0,0],[0,0,0]]
// Output: 0
// Explanation: Increasing the height of any building will result in the skyline changing.

public class TotalSumHeight {
    public static void main(String[] args) {
        int[][] grid1 = 
        {
            {1,2,1},
            {2,0,0},
            {3,0,0}
        };
        int[][] grid2 = 
        {
            {3,0,8,4},
            {2,4,5,7},
            {9,2,6,3},
            {0,3,1,0}
        };
        int[][] grid3 = 
        {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };

        System.out.println(getMaxHeightIncrease(grid1));
        System.out.println(getMaxHeightIncrease(grid2));
        System.out.println(getMaxHeightIncrease(grid3));
    }

    public static int getMaxHeightIncrease(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        

        int sum = 0;
        for(int i = 0; i < grid.length;i++) {
            for(int j = 0; j < grid[i].length; j++) {
                rowMax[i] = grid[i][j] > rowMax[i] ? grid[i][j] : rowMax[i]; 
                colMax[j] = grid[i][j] > colMax[j] ? grid[i][j] : colMax[j]; 
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int height = Math.min(rowMax[i], colMax[j]);
                if(height > grid[i][j]) {
                    sum += height - grid[i][j];
                    grid[i][j] = height;
                }
            }
        }

        return sum;
    }



}
