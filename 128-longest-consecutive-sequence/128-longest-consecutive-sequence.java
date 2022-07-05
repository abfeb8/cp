class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        
        var processed = new HashSet<Integer>();
        
        int result = 0;
        for(int i : nums){
            if(!processed.contains(i)){
                int count = 0, curVal = i;
                while(set.contains(curVal)){
                    processed.add(curVal);
                    count++;
                    curVal++;
                }
                result = Math.max(result, count);
            }
        }
        
        return result;
    }
}