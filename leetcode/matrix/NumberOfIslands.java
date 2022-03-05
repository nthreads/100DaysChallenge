public class NumberOfIslands {
    // LC # 200
    // https://leetcode.com/problems/number-of-islands/

    public static void main(String[] args) {
        // 1 Island
        char[][] grid1 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        // 3 Islands
        char[][] grid2 = new char[][]{
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands Founds = " + numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        
        int numIslands = 0;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
                    
            for(int j = 0; j < cols; j++) {
                // check adjecent values when a piece of land '1' found
                if(grid[i][j] == '1') { 
                    markIslandVisited(grid, i, j, rows, cols);
                    numIslands += 1;    
                }                
            }
        }
        
        return numIslands;
    }
    
      
    private static void markIslandVisited(char[][] grid, int i, int j, int rows, int cols) {
        // Check the edge cases
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') return;
        
        grid[i][j] = '2'; // Mark it as visited        
        
        markIslandVisited (grid, i - 1, j, rows, cols); //left
        markIslandVisited (grid, i + 1, j, rows, cols); //right                    
        markIslandVisited (grid, i, j - 1, rows, cols); //up
        markIslandVisited (grid, i, j + 1, rows, cols); //down        
    }
}
