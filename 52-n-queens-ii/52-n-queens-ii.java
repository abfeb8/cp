class Solution {
    public int totalNQueens(int n) {
        var board = new char[n][n];
        int result = 0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                board[r][c] = '.';
            }
        }
        
        result = helper(0, n, board);
        return result;
    }
    
    private int helper(int r, int n, char[][] board){
        if(r == n)
            return 1;
        
        int result = 0;
        for(int c = 0; c<n; c++){
            if(isValid(n, board, r, c)){
                board[r][c] = 'Q';
                result+=helper(r+1, n, board);
                board[r][c] = '.';
            }
        }
        
        return result;
    }
    
    private boolean isValid(int n, char[][] board, int r, int c){
        int posDiag = r+c, negDiag = r-c;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'Q' && (i == r || j == c || posDiag == i+j || negDiag == i-j)){
                    return false;
                }
            }
        }
        return true;
    }
}