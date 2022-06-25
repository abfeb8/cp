class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        var colSet = new HashSet<Integer>();
        var posD = new HashSet<Integer>();
        var negD = new HashSet<Integer>();
        var board = new int[n][n];
        
        // starting with first row
        helper(0, colSet, posD, negD, board);   
        
        return result;
    }
    
    private void helper(int row, HashSet<Integer> colSet, HashSet<Integer> posD, HashSet<Integer> negD, int[][] board){
        
        int n = board.length;
        if(row == n){
            result.add(getBoard(board));
            return;
        }
        
        for(int c = 0; c<n; c++){
            if(!colSet.contains(c) && !posD.contains(row+c) && !negD.contains(row-c)){
                // placing queen
                board[row][c] = 1;
                colSet.add(c); posD.add(row+c); negD.add(row-c);
                
                helper(row + 1, colSet, posD, negD, board);
                
                // reseting the board
                board[row][c] = 0;
                colSet.remove(c); posD.remove(row+c); negD.remove(row-c);
            }
        }
    }
    
    private List<String> getBoard(int[][] board){
        List<String> result = new ArrayList<>();
        for(int[] row : board){
            String tempString = "";
            for(int col : row) {
                tempString += col == 1 ? "Q" : ".";
            }
            result.add(tempString);
        }
        return result;
    }
}