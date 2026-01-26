class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board,0,n);
        return result;
    }

    private void backTrack(char[][] board, int idx,int n){
        //base case
        if(idx==n){
            result.add(buildResult(board));
            return;
        }
        //logic
        for(int i=0;i<n;i++){
            if(isSafe(board, idx, i)){
                board[idx][i]='Q';
                backTrack(board, idx+1, n);
                board[idx][i]='.';
            }
        }
    }

    private List<String> buildResult(char[][] board){
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }

    private boolean isSafe(char[][] board, int r, int c){
        //chk if column has Queen
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q')
                return false;
        }
        //chk upper left diagonal 
        int nr=r;
        int nc=c;
        while(nr>=0 && nc>=0){
            if(board[nr][nc]=='Q')
                return false;
            nr--;
            nc--;
        }
        //chk upper right diagonal 
        nr=r;
        nc=c;
        while(nr>=0 && nc<board.length){
            if(board[nr][nc]=='Q')
                return false;
            nr--;
            nc++;
        }
        return true;
    }
}