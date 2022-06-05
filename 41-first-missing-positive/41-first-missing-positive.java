class Solution {
    public int firstMissingPositive(int[] nums) {
        int p = 0; // pointer
        int n = nums.length;
        while(p<n){
            if(nums[p] != p+1 && nums[p] > 0 && nums[p] <= n && nums[p] != nums[nums[p]-1]){
                swap(nums, p, nums[p]-1);
                continue;
            }
            p++;
        }
        
        for(int i = 0; i<n; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        
        return n+1;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}