class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        this.m = board.length;
        this.n = board[0].length;
        
        if (m < 2 || n < 2)
            return;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n-1] == 'O')
                dfs(board, i, n-1);	
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[m-1][j] == 'O')
                dfs(board, m-1, j);	
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O')
            board[i][j] = '*';
        for(int[] dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if (nr>=1 && nc>=1 && nr<m-1 && nc<n-1 && board[nr][nc] == 'O')
                dfs(board, nr, nc);
        }
    }
}