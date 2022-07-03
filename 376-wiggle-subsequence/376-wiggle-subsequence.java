class Solution {
    public int wiggleMaxLength(int[] nums) {
                
        int[] arr = new int[nums.length-1];
        
        for(int i = 1; i<nums.length; i++){
            arr[i-1] = nums[i] - nums[i-1];
        }
        
        int count = 1;
        int p1 = arr.length, p2 = arr.length;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != 0){
                count++;
                p1 = i; p2 = i;
                break;
            }
        }
        
        while(p2 < arr.length){
            // System.out.println(arr[p1]+ " " + arr[p2]);
            if(arr[p1] == 0){
                p1++; p2++;
                continue;
            }
            if((arr[p1]*arr[p2]) < 0){
                count++;
                p1 = p2;
            }
            p2++;
            
        }
        return count;
    }
}