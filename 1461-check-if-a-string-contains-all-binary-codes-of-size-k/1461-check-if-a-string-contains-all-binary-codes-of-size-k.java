class Solution {
    public boolean hasAllCodes(String s, int k) {
        var set = new HashSet<String>();
        
        int l = s.length();
        for(int i = 0; i<=l-k; i++){
            set.add(s.substring(i, i+k));    
        }
        
        return set.size() == 1 << k;
    }
}