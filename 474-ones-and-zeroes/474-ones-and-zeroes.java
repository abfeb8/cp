class Solution {
    int[][][] dpTable;
    public int findMaxForm(String[] strs, int m, int n) {
        dpTable = new int[m+1][n+1][strs.length];
        return helper(strs, m, n, 0);
    }
    
    private int helper(String[] strs, int m, int n, int index){
        if((m == 0 && n == 0) || index >= strs.length){
            return 0;
        }
        
        if(dpTable[m][n][index] != 0)
            return dpTable[m][n][index];
   
        int[] counts = getCount(strs[index]);
        int curMax = 0;
        
        
        if(counts[0] <= m && counts[1] <= n){
            curMax = Math.max(
                helper(strs, m-counts[0], n-counts[1], index+1) + 1, 
                helper(strs, m, n, index+1));
        } else {
            curMax = helper(strs, m, n, index+1);
        }
        
        dpTable[m][n][index] = curMax;
        return curMax;
    }
    
    private int[] getCount(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            if(c == '0')
                count[0]++;
            else
                count[1]++;
        }
        return count;
    }
}