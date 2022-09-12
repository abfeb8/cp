class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        return getMaxScore(tokens, 0, tokens.length-1, 0, power);
    }
    
    private int getMaxScore(int[] tokens, int l, int r, int score, int power){
        if(r<l || (tokens[l]>power && score<1)){
            return score;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append(r);
        sb.append(score);
        sb.append(power);
        String key = sb.toString();
        if(cache.containsKey(key))
            return cache.get(key);
        // System.out.println(l + " " + r + " " + score + " " + power);
        if(score == 0){
            cache.put(key, Math.max(score, getMaxScore(tokens, l+1, r, score+1, power-tokens[l])));
        } else if(power<tokens[l]) {
            cache.put(key, Math.max(score, getMaxScore(tokens, l, r-1, score-1, power+tokens[r])));
        } else {
            cache.put(key, Math.max(score, Math.max(getMaxScore(tokens, l+1, r, score+1, power-tokens[l]), 
                              getMaxScore(tokens, l, r-1, score-1, power+tokens[r]))));
        }
        
        return cache.get(key);
    }
}