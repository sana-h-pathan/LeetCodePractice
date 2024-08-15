class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    if((set.contains(ch+"in row"+i))|| (set.contains(ch+"in column"+j)) || (set.contains(ch+"in row"+i/3+"-"+j/3))){
                        return false;
                    }
                    set.add(ch+"in row"+i);
                    set.add(ch+"in column"+j);
                    set.add(ch+"in row"+i/3+"-"+j/3);
                }
            }
        }
        return true;
    }
}