class Solution {
    int m;
    int n;
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, i, j, 0, word))
                    return true;
            }
        }
        return false; 
    }
    private boolean backtrack(char[][] board, int i, int j, int idx, String word){
        //base case
        if(word.length()==idx)
            return true;
        if(i<0 || j<0 || i==m || j==n ||board[i][j]=='#')
            return false;
        //logic
        if(board[i][j]==word.charAt(idx)){
            board[i][j]='#';
            for(int[] dir: dirs){
                int nr=i+dir[0];
                int nc=j+dir[1];
                if(backtrack(board, nr, nc, idx+1, word))
                    return true;
            }
            //backtrack
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}