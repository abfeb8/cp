class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int n1 = c1.length, n2 = c2.length;
        dp = new int[n1+1][n2+1];
        
        int p1 = 0, p2 = 0;
        helper(c1, c2, p1, p2);
        // System.out.printf("- ");
        // for(char c : c2){
        //     System.out.printf(c + " ");
        // }
        // System.out.println();
        // int k = -1;
        // for(int[] a : dp){
        //     for(int i : a)
        //         System.out.printf(i + " ");
        //     System.out.println(k == -1 ? "-" : c1[k]);
        //     k++;
        // }
        
        return dp[0][0];
    }
    
    private int helper(char[] c1, char[] c2, int p1, int p2){
        int n1 = c1.length, n2 = c2.length;
        if(p1>=n1 || p2>=n2){
            return 0;
        }
        
        if (dp[p1][p2] != 0)
            return dp[p1][p2];
        
        if(c1[p1] == c2[p2]){
            dp[p1][p2] = 1 + helper(c1, c2, p1+1, p2+1);
        }else{
            dp[p1][p2] = Math.max(helper(c1, c2, p1+1, p2), helper(c1, c2, p1, p2+1));
        }
        
        return dp[p1][p2];
    }
}