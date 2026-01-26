class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(board, 0, n);
        return result;
    }
    private void backtrack(char[][] board, int idx, int n){
        if(idx==n){
            result.add(buildResult(board));
            return;
        }

        for(int j=0;j<n;j++){
            if(isSafe(board, idx, j)){
                board[idx][j]='Q';
                backtrack(board, idx+1, n);
                board[idx][j]='.';
            }
        }
    }
    private boolean isSafe(char[][] board, int r, int c){
        //chk if it exist in above column
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        //check in upper left diagonal
        int nr = r;
        int nc = c;
        while(nr>=0 && nc>=0){
            if(board[nr][nc]=='Q'){
                return false;
            }
            nr--;
            nc--;
        }
        nr = r;
        nc = c;
        while(nr>=0 && nc<board.length){
            if(board[nr][nc]=='Q'){
                return false;
            }
            nr--;
            nc++;
        }
        return true;
    }

    private List<String> buildResult(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            temp.add(row);
        }
        return temp;
    }
}