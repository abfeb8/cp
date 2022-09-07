class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int r = 1; r<dp.length; r++){
            for(int c = 1; c<dp[0].length; c++){
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
        
        return dp[m][n];
    }
}