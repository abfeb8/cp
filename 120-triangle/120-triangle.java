class Solution {
    
    Map<String, Integer> cache = new HashMap<>(); 
    
    public int minimumTotal(List<List<Integer>> triangle) {
        var dp = new ArrayList<List<Integer>>();
        dp.add(triangle.get(0));
        
        int n = triangle.size();
        
        for(int r = 1; r<n; r++){
            Integer[] arr = new Integer[r+1];
            for(int c = 0; c<=r; c++){
               arr[c] = Math.min(dp.get(r-1).get(Math.max(0, c-1)), dp.get(r-1).get(Math.min(r-1, c))) + triangle.get(r).get(c);
            }
            dp.add(Arrays.asList(arr));
        }
        
        int result = Integer.MAX_VALUE;
        for(int i : dp.get(n-1)){
            result = Math.min(result, i);
        }
        
        return result;
        
    }
    
    private int topDown(List<List<Integer>> triangle, int n, int row, int col){
        if(row == n-1){
            return triangle.get(row).get(col);
        }
        
        String key = row+"-"+col;
        if(cache.containsKey(key))
            return cache.get(key);
        
        int curVal = triangle.get(row).get(col);
        int minPath = Math.min(topDown(triangle, n, row+1, col), topDown(triangle, n, row+1, col+1)) + curVal;
        cache.put(key, minPath);
        return minPath;
    }
}