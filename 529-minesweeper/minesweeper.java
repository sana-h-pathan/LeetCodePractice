class Solution {
    int m;
    int n;
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        Queue<int[]> bfsQue = new LinkedList<>();
        bfsQue.add(new int[]{click[0],click[1]});
        board[click[0]][click[1]]='B';
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            int mines = countMines(board, curr[0], curr[1]);
            if(mines==0){
                for(int[] dir: dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='E'){
                        board[nr][nc]='B';
                        bfsQue.add(new int[]{nr, nc});

                    }
                }
            } else {
                board[curr[0]][curr[1]] = (char)(mines+'0');
            }
        }
        return board;
    }

    private int countMines(char[][] board, int i, int j){
        int count=0;
        for(int[] dir : dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='M'){
                count++;
            }
        }
        return count;
    }
}