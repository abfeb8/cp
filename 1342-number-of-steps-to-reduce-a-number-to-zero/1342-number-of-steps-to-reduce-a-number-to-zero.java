class Solution {
    public int numberOfSteps(int num) {
        int result = 0;
        while(num>0){
            if((num&1) == 1)
                num-=1;
            else
                num/=2;
            result++;
        }
        
        return result;
    }
}