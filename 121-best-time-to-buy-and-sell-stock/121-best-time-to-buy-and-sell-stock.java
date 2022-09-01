class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for(int price : prices){
            min = price<min ? price : min;
            result = Math.max(result, price-min);
        }
        
        return result;
    }
}