class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        
        int result = 0;
        for(int i : nums){
            if(set.contains(i)){
                set.remove(i);
                int left = i, right = i;
                while(set.contains(left-1)){
                    set.remove(left);
                    left--;
                }
                while(set.contains(right+1)){
                    set.remove(right);
                    right++;
                }
                result = Math.max(result, right-left+1);
            }
        }
        
        return result;
    }
}