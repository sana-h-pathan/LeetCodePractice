class Solution {
    int m;
    int n;
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int r = click[0];
        int c = click[1];
        if(board[r][c]=='M'){
            board[r][c] = 'X';
            return board;
        }
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{r,c});
        board[r][c] = 'B';
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            int mines = countMines(board, curr[0], curr[1]);
            if(mines==0){
                for(int[] dir: dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='E'){
                        bfsQue.add(new int[]{nr, nc});
                        board[nr][nc] = 'B';
                    }
                }
            } else {
                board[curr[0]][curr[1]] = (char)(mines+'0');
            }
        }
        return board;
    }
    private int countMines(char[][] board, int r, int c){
        int mines = 0;
        for(int[] dir: dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='M'){
                mines++;
            }
        }
        return mines;
    }
}