class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n*(n+1)/2;
        for(int i : nums)
            result-=i;
        
        return result;
    }
}