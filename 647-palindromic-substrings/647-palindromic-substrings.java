class Solution {
    int[] cache;
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        cache = new int[arr.length+1];
        for(int len = 1; len <= arr.length; len++){
            cache[len] = cache[len-1] + countNewPalindrom(arr, len);
        }
        return cache[arr.length];
    }
    
    private int countNewPalindrom(char[] arr, int end){
        int result = 0;
        
        for(int start = 0; start < end; start++){
            if(isPalindrome(start, end-1, arr))
                result++;
        }
        
        return result;
    }
    
    private boolean isPalindrome(int l, int r, char[] arr){
        while(l<r)
            if(arr[l++] != arr[r--])
                return false;
        
        return true;
    }
}