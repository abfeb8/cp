class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // preprocess
        int[] bMax = new int[26];
        for(String s : words2){
            int[] b = getFreq(s);
            for(int j  = 0; j<26; j++){
                bMax[j] = Math.max(bMax[j], b[j]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String s : words1){
            int[] a = getFreq(s);
            if(isSubSet(a, bMax)){
                ans.add(s);
            }
        }
        
        return ans;
    }
    
    private int[] getFreq(String s){
        int[] fr = new int[26];
        for(char c : s.toCharArray()){
            fr[c-'a']++;
        }
        return fr;
    }
    
    private boolean isSubSet(int[] a, int[] b){
        for(int i = 0; i<26; i++){
            if(a[i] < b[i])
                return false;
        }
        return true;
    }
    
    private boolean isUniversal(int[] a, int[][] arr){
        for(int[] b : arr){
            if(!isSubSet(a, b))
                return false;
        }
        return true;
    }
}