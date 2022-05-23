class Solution {
    int[] cache;
    int max = 100001;
    public int coinChange(int[] coins, int amount) {
        cache = new int[amount+1];
        Arrays.fill(cache, max);
        cache[0] = 0;
        helper(coins, amount);
        int result = cache[amount];
        if(result >= max)
            return -1;
        return result;
    }
    
    private void helper(int[] coins, int amount){
        for(int amt = 1; amt <= amount; amt++){
            for(int coin : coins){
                if(coin <= amt)
                    cache[amt] = Math.min(cache[amt], 1 + cache[amt-coin]);
            }
        }
    }
}

// coins -> [2,3,4,5]
// amount -> 7
 
// amt = 0 | cache -> [0, 100001, 100001, 100001, 100001, 100001, 100001, 100001]
// since its not possible to calculate 1 with the available coins
// amt = 1 | cache -> [0, 100001, 100001, 100001, 100001, 100001, 100001, 100001] 
// amt = 2 | cache -> [0, 100001, 1, 100001, 100001, 100001, 100001, 100001]
// amt = 3 | cache -> [0, 100001, 1, 1, 100001, 100001, 100001, 100001]
// amt = 4 | cache -> [0, 100001, 1, 1, 1, 100001, 100001, 100001] 
// amt = 5 | cache -> [0, 100001, 1, 1, 1, 1, 100001, 100001]
// amt = 6 | cache -> [0, 100001, 1, 1, 1, 1, 2, 100001]
// amt = 7 | cache -> [0, 100001, 1, 1, 1, 1, 2, 2]