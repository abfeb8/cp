class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int curVal = nums[i];
            if(curVal != i+1 && curVal>0 && curVal<(n+1)) {
                if(curVal > i+1){
                    while(curVal != i+1 && curVal>0 && curVal<(n+1)){
                        if(nums[i] == nums[curVal-1])
                            break;
                        nums[i] = nums[curVal-1];
                        nums[curVal-1] = curVal;
                        curVal = nums[i];
                    }
                } else {
                    nums[curVal-1] = curVal;
                }
            } 
        }
        
        for(int i = 1; i<=n; i++){
            if (i!=nums[i-1]){
                return i;
            }
        }
        
        return n+1;
    }
}