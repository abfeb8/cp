class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int amt = 1; amt<dp.length; amt++){
            for(int c : coins){
                if(c<=amt){
                    dp[amt] = Math.min(dp[amt], dp[amt-c] + 1);
                }
            }
        }
        
        return (int)dp[amount] == Integer.MAX_VALUE ? -1 : (int)dp[amount];
    }
}