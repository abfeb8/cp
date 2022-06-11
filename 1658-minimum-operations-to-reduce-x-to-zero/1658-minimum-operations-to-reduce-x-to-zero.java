class Solution {
    HashMap<String, Integer> cache = new HashMap<String, Integer>();
    
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i<n; i++)
            prefixSum[i] = nums[i]+prefixSum[i-1];
        
        int sum = prefixSum[n-1] - x;
        
        if(sum == 0)
            return n;
        
        int l = 0, r = 0, result = 0;
        
        while(l<=r && r<n){
            int curSum = prefixSum[r] - prefixSum[l] + nums[l];
            // System.out.println(l+" "+r+"->"+curSum+" "+sum);
            if(curSum == sum){
                result = Math.max(result, r-l+1);
            }
            if(curSum > sum){
                if(l == r){
                    l++; r++;
                } else
                    l++;
                continue;
            }
            r++;
        }
        
        return result == 0 ? -1 : n - result;
    }
    
}