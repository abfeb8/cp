class Solution {
    int[][] time;
    int max = 10000;
    public int orangesRotting(int[][] grid) {
        time = new int[grid.length][grid[0].length];
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                int curVal = grid[r][c]; 
                if(curVal == 2){
                    time[r][c] = 0;
                } else {
                    time[r][c] = max;
                }
            }
        }
        
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                int curVal = grid[r][c]; 
                if(curVal == 2){
                    bfs(grid, r, c);
                }
            }
        }
        
        int result = 0;
        
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                int curVal = grid[r][c], t = time[r][c]; 
                // System.out.printf((t == max ? -1 : t) + " ");
                if(curVal > 0){
                    result = Math.max(result, t);
                }
            }
            // System.out.println();
        }
        
        
        return result == max ? -1 : result;
    }
    
    private void bfs(int[][] grid, int r, int c){
        Queue<List<Integer>> q = new LinkedList<List<Integer>>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] k = new int[]{0, 1,-1};
        q.add(List.of(r,c));
        while(!q.isEmpty()){
            List<Integer> temp = q.poll();
            r = temp.get(0); c = temp.get(1);
            visited[r][c] = true;
            for(int i : k){
                for(int j : k){
                    int row = r+i, col = c+j;
                    if(!(i == j) && (i != j*-1) && row >= 0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] != 0 && !visited[row][col]){
                        q.add(List.of(row, col));
                        time[row][col] = Math.min(time[row][col], time[r][c] + 1);
                    }
                }
            }
            // System.out.println(r + "," + c + " " + grid[r][c]);
            // for(int i = 0; i<grid.length; i++){
            //     for(int j = 0; j<grid[0].length; j++){
            //         int curVal = grid[i][c], t = time[i][j]; 
            //         System.out.printf((t == max ? "-" : t) + " ");
            //     }
            //     System.out.println();
            // }
        }
    }
}