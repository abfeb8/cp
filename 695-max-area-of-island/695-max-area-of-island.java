class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea, getArea(grid, r, c));
                }
            }
        }
        
        return maxArea;
    }
    
    private int getArea(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c>= grid[0].length){
            return 0;
        }
        if(grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        return 1 + getArea(grid, r+1, c) + getArea(grid, r, c+1) + getArea(grid, r-1, c) + getArea(grid, r, c-1);
    }
}