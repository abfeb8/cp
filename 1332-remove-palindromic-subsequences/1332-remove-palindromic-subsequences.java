class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        
        int p1 = 0, p2 = n-1;
        while(p1<p2){
            if(s.charAt(p1++) != s.charAt(p2--))
               return 2;
        }
               
        return 1;
    }
}