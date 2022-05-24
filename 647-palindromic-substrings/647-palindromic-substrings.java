class Solution {
    int[] cache;
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        cache = new int[arr.length+1];
        
        for(int indx = 0; indx < arr.length; indx++){
            cache[indx+1] = cache[indx] + countNewPalindrom(arr, indx);
            // System.out.println(indx+1 + "->" + cache[indx+1]);
        }
        return cache[arr.length];
    }
    
    private int countNewPalindrom(char[] arr, int index){
        int result = 0, l = index, r = index;
        
        // count odd palindrome
        while(l >= 0 && r < arr.length){
            if(arr[l--] != arr[r++])
                break;
            result++;
        }
        
        //count even palindrome
        l = index-1; r = index;
        while(l >= 0 && r < arr.length){
            if(arr[l--] != arr[r++])
                break;
            result++;
        }
        
        return result;
    }
    
    
    
}