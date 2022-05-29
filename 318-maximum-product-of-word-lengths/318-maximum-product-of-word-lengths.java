class Solution {
    public int maxProduct(String[] words) {
        
        //pre process
        int[] bits = new int[words.length];
        for(int i = 0; i<words.length; i++){
            int temp = 0;
            for(char c : words[i].toCharArray()){
                temp|=1<<(c-'a');
            }
            bits[i] = temp;
        }
        
        int result = 0;
        for(int i = 0; i<words.length-1; i++){
            for(int j = i+1; j<words.length; j++){
                if((bits[i]&bits[j]) == 0)
                    result = Math.max(words[i].length() * words[j].length(), result);
            }
        }
        return result;
    }

}