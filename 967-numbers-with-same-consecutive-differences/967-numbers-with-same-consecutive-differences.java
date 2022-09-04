class Solution {
    int[][] map = new int[10][2];
    public int[] numsSameConsecDiff(int n, int k) {
        fillMap(map, k);
        List<String> result = new ArrayList<>();
        
        for(int i = 1; i<10; i++){
            getNumbers(i, String.valueOf(i), n-1, result);
        }
        
        return result.stream().mapToInt(s -> Integer.valueOf(s)).toArray();
    }
    
    private void getNumbers(int i, String s, int n, List<String> result){
        if(i < 0 || i > 9)
            return;
        
        if(n == 0) {
            result.add(s);
            return;
        }
        
        for(int num : map[i]){
            getNumbers(num, new String(s + String.valueOf(num)), n-1, result);
        }
    }
    
    private void fillMap(int[][] map, int k){
        for(int i = 0; i<10; i++){
            map[i][0] = i-k;
            map[i][1] = i+k == i ? -1 : i+k;
        }
    }
}