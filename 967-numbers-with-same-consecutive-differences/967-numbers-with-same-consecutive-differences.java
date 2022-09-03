class Solution {
    String[] cache = new String[11];
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<>();
        
        for(int i = 1; i<10; i++)
            helper(i, new String(), n, k, result);
        
        List<Integer> list = new ArrayList<>(result);
        int[] array = new int[list.size()];
        for(int i = 0; i<array.length; i++){
            array[i] = list.get(i);
        }
        return array;
    }
    
    private void helper(int i, String s, int n, int k, Set<Integer> result) {
        if(i < 0 || i > 9)
            return;
        
        if(n == 0){
            result.add(Integer.valueOf(s));
            return;
        }
        
        helper(i-k, new String(s + String.valueOf(i)), n-1, k, result);
        helper(i+k, new String(s + String.valueOf(i)), n-1, k, result);
    }
}