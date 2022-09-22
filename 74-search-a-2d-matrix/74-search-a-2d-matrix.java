class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        
//         binary search
        int s = 0, e = (r*c)-1;
        while(s<=e){
            int mid = (s+e)/2;
            int curVal = matrix[mid/c][mid%c];
            if(curVal == target)
                return true;
            if(curVal > target)
                e = mid-1;
            else
                s = mid+1;
        }
        return false;
    }
}