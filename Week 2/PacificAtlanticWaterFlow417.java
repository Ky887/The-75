import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PacificAtlanticWaterFlow417 {
    /*
    Method 1:
    Create two boolean matrices, one of nodes that can be reached form the atlantic ocean, 
    the other form nodes that can be reached from the pacific. 
    Then if a node is in both sets, rain from this node can flow to both coasts 
    and therefore should be added to resultant set. 
    */ 
    public static List<List<Integer>> pacificAtlantic(int[][] heights){
        List<List<Integer>> result = new ArrayList<>(); 
        int row = heights.length, col = heights[0].length; 
        boolean [][] atlantic = new boolean[row][col];  
        boolean[][] pacific = new boolean[row][col]; 
        
        // top & bottom row 
        for(int cols = 0; cols < heights[0].length; cols++){
            dfs(heights, 0, cols, heights[0][cols], pacific); 
            dfs(heights, heights.length-1, cols, heights[heights.length-1][cols], atlantic); 
        }
        // left and right coloumn 
        for(int rows = 0; rows < heights.length; rows++){
            dfs(heights, rows, 0, heights[rows][0], pacific); 
            dfs(heights, rows, heights[rows].length-1, heights[rows][heights[rows].length-1], atlantic); 
        }
        // Looking for intersections between atlantic and pacific nodes
        for(int r = 0; r < heights.length; r ++){
            for(int c = 0; c < heights[r].length; c++){
                if(atlantic[r][c] == true && pacific[r][c]== true){
                    result.add(Arrays.asList(r,c)); 
                }
            }
        }
        return result; 
    }

    public static void dfs(int[][] grid, int r, int c, int prev, boolean[][] visited){
        boolean inBounds =  (0 <= r && r < grid.length) && ( 0 <= c && c < grid[r].length); 
        if((!inBounds) || visited[r][c] == true || grid[r][c] < prev){
            return; 
        }
        visited[r][c] = true; 

        dfs(grid, r+1, c, grid[r][c], visited); 
        dfs(grid, r-1, c, grid[r][c], visited);
        dfs(grid, r, c+1, grid[r][c], visited);
        dfs(grid, r, c-1, grid[r][c], visited);
    }
    public static void main(String[] args) {
        int[][] input = {{3,3,3,3,3,3,},{3,0,3,3,0,3},{3,3,3,3,3,3}}; 
        System.out.println(pacificAtlantic(input).toString());
    }
    
}
