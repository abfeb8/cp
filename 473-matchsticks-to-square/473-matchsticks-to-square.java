class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean makesquare(int[] arr) {
        long parameter = 0, length = -1;
        for(int i : arr){
            parameter += i;
        }
        
        if(parameter%4 != 0) return false;
        
        length = parameter/4;
        Arrays.sort(arr);
        long a = length, b = length, c = length, d = length;
        
        return helper(arr, a, b, c, d, arr.length-1);
    }
    
    private boolean helper(int[] arr, long a, long b, long c, long d, int n){
        if(a < 0 || b < 0 || c < 0 || d < 0){
            return false;
        }
        
        if(n<0) {
            return (a == 0 && a == b && b == c && c == d);
        }
        String key = a+"-"+b+"-"+c+"-"+d;
        
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        boolean flag = helper(arr, a-arr[n], b, c, d, n-1) ||
            helper(arr, a, b-arr[n], c, d, n-1) ||
            helper(arr, a, b, c-arr[n], d, n-1) ||
            helper(arr, a, b, c, d-arr[n], n-1);
        
        cache.put(key, flag);
        return flag;
    }
}