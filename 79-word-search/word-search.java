class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int i, int j, int idx, String word){
       
        
        if(word.charAt(idx)==board[i][j]){
            if(idx==word.length()-1)
                return true;
            board[i][j]='#';
            for(int[] dir: dirs){
                int nr=dir[0]+i;
                int nc=dir[1]+j;
                if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]!='#'){
                    if(backtrack(board,nr,nc,idx+1, word))
                        return true;
                }
            }
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}