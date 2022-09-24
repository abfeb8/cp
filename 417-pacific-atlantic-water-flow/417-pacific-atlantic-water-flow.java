class Solution {
    int[][] water;
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        water = new int[heights.length][heights[0].length];
        
        // water can go to pacific ocean
        for(int r = 0; r<heights.length; r++){
            dfsPacific(heights, r, 0, heights[r][0]);
        }
        for(int c = 0; c<heights[0].length; c++){
            dfsPacific(heights, 0, c, heights[0][c]);
        }
        
//         for(int i = 0; i<water.length; i++){
//             for(int j = 0; j<water[0].length; j++){
//                 System.out.printf(water[i][j] + " ");
//             }
//             System.out.println();
//         }
        
//         System.out.println();
        
        // water can go to atlantic ocean
        for(int r = 0; r<heights.length; r++){
            dfsAtlantic(heights, r, heights[0].length-1, heights[r][heights[0].length-1]);
        }
        for(int c = 0; c<heights[0].length; c++){
            dfsAtlantic(heights, heights.length-1, c, heights[heights.length-1][c]);
        }
        
        for(int i = 0; i<water.length; i++){
            for(int j = 0; j<water[0].length; j++){
                if(water[i][j] == 3) result.add(List.of(i,j));
                // System.out.printf(water[i][j] + " ");
            }
            // System.out.println();
        }
        
        return result;
    }
    
    private void dfsPacific(int[][] heights, int r, int c, int preHeight){
        if(r<0 || r>=heights.length || c<0 || c>=heights[0].length || 
           water[r][c] != 0 || heights[r][c] < preHeight)
        {
            return;
        }
        
        water[r][c]++;
        
        dfsPacific(heights, r+1, c, heights[r][c]);
        dfsPacific(heights, r-1, c, heights[r][c]);
        dfsPacific(heights, r, c+1, heights[r][c]);
        dfsPacific(heights, r, c-1, heights[r][c]);
    }
    
    private void dfsAtlantic(int[][] heights, int r, int c, int preHeight){
        if(r<0 || r>=heights.length || c<0 || c>=heights[0].length || 
            water[r][c] >= 2 || heights[r][c] < preHeight)
        {
            return;
        }
        
        water[r][c] = water[r][c] == 1 ? 3 : 2;
        
        dfsAtlantic(heights, r+1, c, heights[r][c]);
        dfsAtlantic(heights, r-1, c, heights[r][c]);
        dfsAtlantic(heights, r, c+1, heights[r][c]);
        dfsAtlantic(heights, r, c-1, heights[r][c]);
    }
}