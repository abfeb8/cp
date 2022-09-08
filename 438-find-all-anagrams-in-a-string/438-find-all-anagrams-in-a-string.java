class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(p.length()>s.length())
            return result;
        
        int[] frP = new int[26];
        for(char c : p.toCharArray()){
            frP[c-'a']++;
        }
        
        int[] word = new int[26];
        for(int i = 0; i<p.length(); i++){
            word[s.charAt(i) - 'a']++;
        }
        
        
        if(isAnagram(frP, word))
            result.add(0);
        
        int l = 0, r = p.length();
        while(r<s.length()){
            word[s.charAt(l++)-'a']--;
            word[s.charAt(r++)-'a']++;
            if(isAnagram(frP, word))
                result.add(l);
        }
        
        return result;
    }
    
    private boolean isAnagram(int[] p, int[] s){
        for(int i = 0; i<26; i++){
            if(p[i] != s[i])
                return false;
        }
        
        return true;
    }
}