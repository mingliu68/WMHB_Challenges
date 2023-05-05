package SatChallenge_3;

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
// return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally 
// or vertically. You may assume all four edges of the grid are all surrounded by water. 

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

public class NumberOfIslands {
    public static void main(String[] args) {
        String[][] grid1 = {{"1","1","1","1","0"},
                            {"1","1","0","1","0"},
                            {"1","1","0","0","0"},
                            {"0","0","0","0","0"}};

        String[][] grid2 = {{"1","1","0","0","0"},
                            {"1","1","0","0","0"},
                            {"0","0","1","0","0"},
                            {"0","0","0","1","1"}};

        String[][] grid3 = {{"1","1","0","1","0","1","0"},
                            {"1","1","0","0","0","1","1"},
                            {"0","0","1","1","0","1","1"},
                            {"1","0","0","1","1","1","0"}};

        System.out.println(getIslands(grid1));
        System.out.println(getIslands(grid2));
        System.out.println(getIslands(grid3));
    }

    public static int getIslands(String[][] grid) {
        // islands = 0;
        // loop through grid starting from (0,0)
        // when sees "1", increase island count by 1 
        // and start depth first search and look for all neighbors,
        // mark self and all visited neighbors "2" if the cell is "1" 
        // to distinguish them from the rest of the cells
        // once the search is completed, go on to (0, 1) and so on until we reach the end

        int islands = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c].equals("1")) {
                    islands++;
                    recursiveIsland(r, c, grid);
                }
            }
        }

        return islands;

    }
    
    public static void recursiveIsland(int r, int c, String[][] grid) {
        if(!grid[r][c].equals("1") ) return;
        grid[r][c] = "x";
        if(r-1 >= 0) recursiveIsland(r-1, c, grid);
        if(r+1 < grid.length) recursiveIsland(r+1, c, grid);
        if(c-1 >= 0) recursiveIsland(r, c-1, grid);
        if(c+1 < grid[0].length) recursiveIsland(r, c+1, grid);
    }


}
