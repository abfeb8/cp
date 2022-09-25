class Solution {
    public int rob(int[] nums) {
        int a = 0, b = nums[0], temp = nums[0];
        
        for(int i = 2; i<=nums.length; i++){
            temp = b;
            b = Math.max(a + nums[i-1], b);
            a = temp;
        }
        return b;
    }
}