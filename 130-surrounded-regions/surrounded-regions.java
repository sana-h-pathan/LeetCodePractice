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
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='0'){
                    board[i][j]='O';
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
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='O'){
                    bfsQue.add(new int[]{nr,nc});
                    board[nr][nc]='0';
                }
            }
        }
    }
}