class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, minSum = Integer.MAX_VALUE, curSum = 0, totalSum = 0, len = n-k;
        
        if(len == 0){
            return Arrays.stream(cardPoints).sum();
        }
        
        // calcuating initial sum
        for(int i = 0; i<len; i++){
            curSum += cardPoints[i];
        }
        
        minSum = curSum;
        totalSum = curSum;
        
        int l = 0, r = len;
        while(r > 0 && r < n){
            totalSum += cardPoints[r];
            curSum = curSum - cardPoints[l++] + cardPoints[r++];
            minSum = Math.min(curSum, minSum);
        }
        
        return totalSum - minSum;
        
    }
}