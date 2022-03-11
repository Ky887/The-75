public class NumberofIslands200{
    /*
    Method 1: 
    Start on first piece of land ('1')
    Use depth first search to change all connecting pieces of land to '0'. 
    Connecting pieces are defined as pieces to immediat left, right, up, down. 
    Update count each time you reach a new piece of land. (new island)
    */

    public static int numIslands(char[][] grid){
        int count = 0; 
        for(int r = 0; r< grid.length; r++){
            for (int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == '1')
                    count++; 
                    explore(grid, r, c); 
            }
        }
        return count; 
    }


    public static void explore(char[][] grid, int r, int c){
        boolean rowInBounds = 0 <= r && r < grid.length; 
        boolean colInBounds = 0<= c && c <grid[0].length; 

        if(!rowInBounds || !colInBounds || grid[r][c] == '0' )
            return;  
        
        grid[r][c] = '0'; 
        explore(grid, r-1, c); 
        explore(grid, r+1, c);
        explore(grid, r, c-1);
        explore(grid, r, c+1);
         
    }
    public static void main(String[] args) {
        System.out.println("hello world!");
        char[][] input = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','1'},
                          {'0','0','0','1','1'}}; 
        System.out.println(numIslands(input));
        
    }
}