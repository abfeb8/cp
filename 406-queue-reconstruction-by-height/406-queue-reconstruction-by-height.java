class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        var result = new int[n][2];
        Arrays.fill(result, new int[]{-1, -1});
        
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        for(int[] p : people){
            int count = p[1];
            for(int i = 0; i<n; i++){
                if((result[i][0] == -1 || result[i][0] >= p[0]) && count-- == 0){
                    result[i] = p;
                    // print(result);
                }
            }
        }
        
        return result;
    }
    
    private void print(int[][] arr){
        System.out.printf("[");
        for(int[] ar : arr){
            System.out.printf(ar[0]+","+ar[1]+"],[");
        }
        System.out.println();
    }
}