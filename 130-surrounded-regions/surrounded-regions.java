class Solution {
    int m;
    int n;
    int[][] dirs;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            helper(board, i, 0);
            helper(board, i, n-1);
        }
        for(int j=0;j<n;j++){
            helper(board, 0, j);
            helper(board, m-1, j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='0'){
                    board[i][j]='O';
                } else if(board[i][j]=='O'){
                     board[i][j]='X';
                }
            }
        }
    }
    private void helper(char[][] board, int i, int j){
        Queue<int[]> bfsQue = new LinkedList<>();
        if(board[i][j]=='O'){
            bfsQue.add(new int[]{i,j});
            board[i][j]='0';
        }
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            for(int[] dir: dirs){
                int nr = dir[0]+curr[0];
                int nc = dir[1]+curr[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='O'){
                    board[nr][nc] = '0';
                    bfsQue.add(new int[]{nr, nc});
                }
            }
        }
    }
}