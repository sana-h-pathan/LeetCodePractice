class Solution {
    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0)
            return;
        this.m = board.length;
        this.n = board[0].length;
        if(m<2 || n<2)
            return;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                dfs(board, i, 0);
            if(board[i][n-1]=='O')
                dfs(board, i, n-1);
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                dfs(board, 0, j);
            if(board[m-1][j]=='O')
                dfs(board, m-1, j);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>m-1 || j>n-1)
            return;
        if(board[i][j]!='O')
            return;
        if(board[i][j]=='O')
            board[i][j] = '*';
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            dfs(board, nr, nc);
        }
    }
}