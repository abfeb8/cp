class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        
        var processed = new HashMap<Integer, Integer>();
        
        int result = 0;
        for(int i : nums){
            if(!processed.containsKey(i)){
                int count = 0, curVal = i;
                while(set.contains(curVal)){
                    if(processed.containsKey(curVal)){
                        count += processed.get(curVal);
                        result = Math.max(result, count);
                        break;
                    }
                    count++;
                    curVal++;
                }
                processed.put(i, count);
                result = Math.max(result, count);
            }
        }
        
        return result;
    }
}