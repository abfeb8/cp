class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
            return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    private boolean helper(String s1, String s2, String s3, int a, int b, int i){
        String key = a+"_"+b+"_"+i;
        if(cache.containsKey(key))
            return cache.get(key);
        
        while(a<s1.length() && b<s2.length()){
            if(s1.charAt(a) == s2.charAt(b)){
                if(s1.charAt(a) == s3.charAt(i))
                    return helper(s1, s2, s3, a+1, b, i+1) || helper(s1, s2, s3, a, b+1, i+1);
                else{
                    cache.put(key, false);
                    return false;
                } 
            }
            if(s1.charAt(a) == s3.charAt(i)){
                a++;
            }else if(s2.charAt(b) == s3.charAt(i)){
                b++;
            }else{
                cache.put(key, false);
                return false;
            }
            i++;
        }
        
        for(int k = a; k<s1.length(); k++){
            if(s1.charAt(k) != s3.charAt(i++)){
                cache.put(key, false);
                return false;
            }
        }
        
        for(int k = b; k<s2.length(); k++){
            if(s2.charAt(k) != s3.charAt(i++)){
                cache.put(key, false);
                return false;
            }
        }
        
        cache.put(key, true);
        return s3.length() == i;
    }
}