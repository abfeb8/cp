class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(climb(cost, 0), climb(cost, 1));
    }
    
    private int climb(int[] cost, int step){
        if(step >= cost.length){
            return 0;
        }
        if(step == cost.length-1){
            return cost[step];
        }
        
        if(cache[step] != -1){
            return cache[step];
        }
        
        int temp = Math.min(climb(cost, step+1), climb(cost, step+2)) + cost[step];
        cache[step] = temp;
        return temp;
    }
}