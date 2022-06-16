class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] res = new int[2];
        
        for(int i = 0; i<n; i++){
            //checking for odd palindrome
            int l = i, r = i;
            while(l>=0 && r<n){
                if(arr[l]!=arr[r])
                    break;
                if(res[1] - res[0] < r-l){
                    res[0] = l;
                    res[1] = r;
                }
                l--; r++;
            }
            
            //checking for even palindrome
            l = i; r = i+1;
            while(l>=0 && r<n){
                if(arr[l]!=arr[r])
                    break;
                if(res[1] - res[0] < r-l){
                    res[0] = l;
                    res[1] = r;
                }
                l--; r++;
            }  
        }
        
        // System.out.println(res[0]+ " " + res[1]);
        
        return s.substring(res[0], res[1]+1);
    }
}