class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, result = 0;
        for(int i = 0; i<prices.length; i++){
            int price = prices[i];
            if(price < min){
                min = price;
            }else{
                result = Math.max(result, price-min);
            }
            
            
        }
        
        return result;
    }
}