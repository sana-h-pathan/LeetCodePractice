class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = countAliveCells(board, i,j);
                if(board[i][j]==1){
                    if(countAlive<2 || countAlive>3){
                        board[i][j]=10;
                    }
                } else if(board[i][j]==0){
                    if(countAlive==3){
                        board[i][j]=11;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==10){
                    board[i][j]=0;
                } else if(board[i][j]==11){
                    board[i][j]=1;
                }
            }
        }
    }
    private int countAliveCells(int[][] board, int r, int c){
        int count=0;
        for(int[] dir: dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==10)){
                count++;
            }
        }
        return count;
    }
}