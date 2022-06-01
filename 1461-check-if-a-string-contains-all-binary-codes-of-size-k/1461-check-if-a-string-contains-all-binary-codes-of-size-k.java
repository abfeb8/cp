class Solution {
    public boolean hasAllCodes(String s, int k) {
        var set = new HashSet<Integer>();
        
        int l = s.length();
        for(int i = 0; i<=l-k; i++){
            set.add(Integer.parseInt(s.substring(i, i+k), 2));    
        }
        
        return set.size() == 1 << k;
    }
}