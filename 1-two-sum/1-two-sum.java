class Solution {
    public int[] twoSum(int[] nums, int target) {
        var check = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            int rem = target - nums[i];
            if(check.containsKey(rem))
                return new int[]{check.get(rem), i};
            else
                check.put(nums[i], i);
        }
        
        return new int[2];
    }
}