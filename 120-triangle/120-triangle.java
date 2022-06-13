class Solution {
    
    Map<String, Integer> cache = new HashMap<>(); 
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        
        for(int r = 1; r<n; r++){
            for(int c = r; c>=0; c--){
               dp[c] = Math.min(dp[Math.max(0, c-1)], dp[Math.min(r-1, c)]) + triangle.get(r).get(c);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i : dp){
            result = Math.min(result, i);
        }
        
        return result;
        
    }
    
    private int topDown(List<List<Integer>> triangle, int n, int row, int col){
        if(row == n-1){
            return triangle.get(row).get(col);
        }
        
        String key = row+"-"+col;
        if(cache.containsKey(key))
            return cache.get(key);
        
        int curVal = triangle.get(row).get(col);
        int minPath = Math.min(topDown(triangle, n, row+1, col), topDown(triangle, n, row+1, col+1)) + curVal;
        cache.put(key, minPath);
        return minPath;
    }
}