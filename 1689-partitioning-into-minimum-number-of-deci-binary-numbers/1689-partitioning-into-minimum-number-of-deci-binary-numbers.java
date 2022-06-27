class Solution {
    public int minPartitions(String n) {
        char[] arr = n.toCharArray();
        
        int max = 0;
        
        for(char c : arr){
            max = max > (c-'0') ? max : c-'0';
            if(max == 9)
                return 9;
        }
        
        return max;
    }
}