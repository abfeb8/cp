class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for(int i = 0; i<boxTypes.length && truckSize > 0; i++){
            int[] box = boxTypes[i];
           
            if(box[0] <= truckSize){
                result += (box[0]*box[1]);
                truckSize -= box[0];
            } else {
                result += (truckSize*box[1]);
                truckSize = 0;
            }
            
        }
        
        return result;
    }
}