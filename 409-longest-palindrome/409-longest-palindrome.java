class Solution {
    public int longestPalindrome(String s) {
        int[] fr = new int[60];
        for(char c : s.toCharArray()){
            fr[c-'A']++;
        }
        
        boolean isOddPresent = false;
        int length = 0;
        for(int f : fr){
            if(f>0){
                if((f&1) == 1){
                    isOddPresent = true;
                    length += f-1;
                } else{
                    length += f;
                }
            }
        }
        
        return isOddPresent ? length+1 : length;
    }
}