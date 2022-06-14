class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    
    public int minDistance(String word1, String word2) {
        char[] a =  word1.toCharArray(), b = word2.toCharArray();
        return a.length + b.length - (count(a, b, 0, 0) * 2);
    }
    
    private int count(char[] a, char[] b, int p1, int p2){
        int n1 = a.length, n2 = b.length;
        if(p1>=n1 || p2>=n2){
            return 0;
        }
        
        String key = p1+"-"+p2;
        if(cache.containsKey(key))
            return cache.get(key);
        
        int temp = 0;
        if(a[p1] == b[p2]){
            temp = count(a, b, p1+1, p2+1) + 1;
        }else{
            temp = Math.max(count(a, b, p1+1, p2), count(a, b, p1, p2+1));
        }
        cache.put(key, temp);
        return temp;
    }
}