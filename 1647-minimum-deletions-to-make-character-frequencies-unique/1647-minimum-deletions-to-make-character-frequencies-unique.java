class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c-'a']+=1;
        }
        
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(int i : freq){
            if(i != 0) q.add(i);
        }
        
        int preVal = Integer.MAX_VALUE, result = 0, curVal;
        while(!q.isEmpty()){
            curVal = q.poll();
            if(curVal>=preVal){
                if(preVal == 0){
                    result += curVal;
                    continue;
                }
                int toRemove = (curVal - preVal) + 1;
                result+=toRemove;
                preVal = curVal - toRemove;
            } else {
                preVal = curVal;
            }
        }
        return result;
    }
}