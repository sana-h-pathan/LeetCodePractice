class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, word, i, j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int idx){
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //base case
        if(word.length()==idx)
            return true;
        

        //logic
        if(board[i][j]==word.charAt(idx)){
            if (idx == word.length() - 1) {
                return true;
            }
            board[i][j]='#';
            for(int[] dir: dirs){
                int nr=dir[0]+i;
                int nc=dir[1]+j;
                if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]!='#'){
                    if(backtrack(board, word, nr, nc, idx+1))
                        return true;
                }
            }
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}