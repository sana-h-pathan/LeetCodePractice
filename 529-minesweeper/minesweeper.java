class Solution {
    int m;
    int n;
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.dirs=new int[][]{{1,0},{0,1},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
        this.m=board.length;
        this.n=board[0].length;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        Queue<int[]> bfsQue=new LinkedList<>();
        bfsQue.add(click);
        board[click[0]][click[1]]='B';
        while(!bfsQue.isEmpty()){
            int[] curr=bfsQue.poll();
            int i=curr[0];
            int j=curr[1];
            int minesAround=countMines(board, curr[0], curr[1]);
            if(minesAround==0){
                for(int[] dir: dirs){
                    int nr=i+dir[0];
                    int nc=j+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='E'){
                        bfsQue.add(new int[]{nr,nc});
                        board[nr][nc]='B';
                    }
                }
            }else if(minesAround>0){
                board[i][j]=(char)(minesAround+'0');
            }
        }
        return board;
    }

    private int countMines(char[][] board, int r, int c){
        int mines=0;
        for(int[] dir: dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='M'){
                mines++;
            }
        }
        return mines;
    }
}