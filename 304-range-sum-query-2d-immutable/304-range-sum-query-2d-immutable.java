class NumMatrix {
    
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        preSum = new int[row][col];
        
        preSum[0][0] = matrix[0][0];
        // filling first row and col of preSum
        for(int i = 1; i<row; i++){
            preSum[i][0] = preSum[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i<col; i++){
            preSum[0][i] = preSum[0][i-1] + matrix[0][i];
        }
        
        for(int r = 1; r<row; r++){
            for(int c = 1; c<col; c++){
                preSum[r][c] = preSum[r-1][c] + preSum[r][c-1] - preSum[r-1][c-1] + matrix[r][c];
            }
        }
        
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        if(r1 == 0 && c1 == 0)
            return preSum[r2][c2];
        
        if(r1 == 0)
            return preSum[r2][c2] - preSum[r2][c1-1];
        
        if(c1 == 0)
            return preSum[r2][c2] - preSum[r1-1][c2];
        
        return preSum[r2][c2] - preSum[r1-1][c2] - preSum[r2][c1-1] + preSum[r1-1][c1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */