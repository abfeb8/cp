class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, min = Integer.MIN_VALUE;
        boolean flag = false;
        
        for(int i = 1; i<n; i++){
            if(nums[i-1] > nums[i]){
                if(flag)
                    return false;
                flag = true;
                if(nums[i] >= min){
                    nums[i-1] = min;
                } else {
                    nums[i] = nums[i-1];
                } 
            }
            min = nums[i-1];
        }
        
        return true;
    }
}