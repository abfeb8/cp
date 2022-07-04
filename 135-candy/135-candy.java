class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        
        // giving one candy to every children
        Arrays.fill(arr, 1);
        // for(int c : arr){
        //     System.out.printf(c+" ");
        // }
        // System.out.println();
        
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i<ratings.length-1; i++){
                if(ratings[i] > ratings[i+1] && arr[i] <= arr[i+1]){
                    flag = true;
                    arr[i]++;
                }   
            }
        }
        
        // for(int c : arr){
        //     System.out.printf(c+" ");
        // }
        // System.out.println();
        
        flag = true;
        while(flag){
            flag = false;
            for(int i = ratings.length-1; i>0; i--){
                if(ratings[i] > ratings[i-1] && arr[i] <= arr[i-1]){
                    flag = true;
                    arr[i]++;
                }
            }
        }
        
        // for(int c : arr){
        //     System.out.printf(c+" ");
        // }
        // System.out.println();
        
        int result = 0;
        for(int c : arr){
            // System.out.printf(c+" ");
            result+=c;
        }
        
        return result;
    }
}