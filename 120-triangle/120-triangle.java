class Solution {
    
    Map<String, Integer> cache = new HashMap<>(); 
    
    public int minimumTotal(List<List<Integer>> triangle) {
        // var dp = new ArrayList<List<Integer>>();
        // dp.add(Arrays.asList(triangle.get(0)));
        
        int n = triangle.size();
        return helper(triangle, n, 0, 0);
        
    }
    
    private int helper(List<List<Integer>> triangle, int n, int row, int col){
        if(row == n-1){
            return triangle.get(row).get(col);
        }
        
        String key = row+"-"+col;
        if(cache.containsKey(key))
            return cache.get(key);
        
        int curVal = triangle.get(row).get(col);
        int minPath = Math.min(helper(triangle, n, row+1, col), helper(triangle, n, row+1, col+1)) + curVal;
        cache.put(key, minPath);
        return minPath;
    
    }
}