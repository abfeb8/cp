class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int result = arr.length;
        
        for(int i = 1; i<=arr.length; i++){
            for(int l = 0; l < (arr.length-i); l++){
                if(isPalindrome(l, l+i, arr))
                    result++;
            }
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