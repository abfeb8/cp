class Solution {
    public int lengthOfLongestSubstring(String str) {
        var map = new HashMap<Character, Integer>();
        var arr = str.toCharArray();
        int s = 0, e = 0, max = 0;
        
        while(e < arr.length){
            char c = arr[e];
            if(map.containsKey(c) && map.get(c) >= s){
                max = Math.max(max, e-s);
                s = map.get(c)+1;
            }
            map.put(c, e++);
        }
        // since we are only updating max value on hitting duplicate char
        // hence we need to check at the completion of loop also
        max = Math.max(max, e-s);
        
        return max;
    }
}