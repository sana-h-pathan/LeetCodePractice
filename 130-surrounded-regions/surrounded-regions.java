class Solution {
    int[][] dirs;
    int m;
    int n;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        if(m<2 || n<2)
            return;
        for(int i=0;i<m;i++){ //run for all rows but 1st and last column 
            helper(board,i,0);
            helper(board, i, n-1);
        }
        for(int j=0;j<n;j++){ //run for all columns but 1st and last row 
            helper(board, 0, j);
            helper(board, m-1, j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='0'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void helper(char[][] board, int r, int c){
        if(r<0 || c<0 || r>m-1|| c>n-1)
            return;
        if(board[r][c]=='O'){
            board[r][c] = '0';
            for(int[] dir: dirs){
                int nr = dir[0]+r;
                int nc = dir[1]+c;
                helper(board, nr, nc);
            }
        }
    }
}