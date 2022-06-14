class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    
    public int minDistance(String word1, String word2) {
        char[] a =  word1.toCharArray(), b = word2.toCharArray();
        int[][] dp = new int[a.length+1][b.length+1];
        
        // i and j represents length of a and b respectively
        for(int i = 1; i<=a.length; i++){
            for(int j = 1; j<=b.length; j++){
                dp[i][j] = a[i-1] == b[j-1] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        // return a.length + b.length - (topDown(a, b, 0, 0) * 2);
        return a.length + b.length - (2 * dp[a.length][b.length]);
    }
    
    private int topDown(char[] a, char[] b, int p1, int p2){
        int n1 = a.length, n2 = b.length;
        if(p1>=n1 || p2>=n2){
            return 0;
        }
        
        String key = p1+"-"+p2;
        if(cache.containsKey(key))
            return cache.get(key);
        
        int temp = 0;
        if(a[p1] == b[p2]){
            temp = topDown(a, b, p1+1, p2+1) + 1;
        }else{
            temp = Math.max(topDown(a, b, p1+1, p2), topDown(a, b, p1, p2+1));
        }
        cache.put(key, temp);
        return temp;
    }
}