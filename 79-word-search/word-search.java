class Solution {
    int m; int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if(board==null)
            return false;
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,0,i,j))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word,int idx, int i, int j){
        //base case
        if(idx==word.length())
            return true;
        if(i<0||j<0||i==m||j==n||board[i][j]=='#')
            return false;
        if(board[i][j]==word.charAt(idx)){
            board[i][j]='#';
            for(int[] dir: dirs){
                int nr=dir[0]+i;
                int nc=dir[1]+j;
                if(backtrack(board, word, idx+1, nr, nc))
                    return true;
            }
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}