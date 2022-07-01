class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] units = new int[1001];
        
        for(int[] box : boxTypes){
            units[box[1]] += box[0];
        }
        
        int result = 0;
        for(int i = 1000; i>=0 && truckSize>0; i--){
            int count = units[i];
            if(count != 0){
                if(count <= truckSize){
                    result += count*i;
                    truckSize -= count;
                } else {
                    result += truckSize*i;
                    return result;
                }
            }
        }
        
        return result;
    }
}