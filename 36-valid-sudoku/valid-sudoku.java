class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    if(set.contains(ch +" in row " + i)|| set.contains(ch +" in column " + j) ||
                        set.contains(ch +" in row/colum " + i/3+"/"+j/3)){
                            return false;
                    }
                    set.add(ch +" in row " + i);
                    set.add(ch +" in column " + j);
                    set.add(ch +" in row/colum " + i/3+"/"+j/3);
                }
                
            }
        }
        return true;
    }
}