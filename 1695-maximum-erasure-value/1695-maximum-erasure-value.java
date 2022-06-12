class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        var preSum = new int[n];
        preSum[0] = nums[0];
        
        for(int i = 1; i<n; i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        
        var map = new HashMap<Integer, Integer>();
        int l = 0, result = 0;
        for(int r = 0; r<n; r++){
            int curVal = nums[r];
            if(map.containsKey(curVal) && map.get(curVal)>=l){
                l = map.get(curVal) + 1;
            }
            result = Math.max(result, preSum[r]-preSum[l]+nums[l]);
            map.put(curVal, r);
        }
        
        return result;
    }
}