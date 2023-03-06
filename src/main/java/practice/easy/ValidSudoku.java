package practice.easy;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku=new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));
    }

    private boolean isValidSudoku(char[][] sudoku) {
        HashSet<String> seenElement=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char number=sudoku[i][j];
                if(number!='.'){
                    if(!seenElement.add(number + " in row " + i) ||
                            !seenElement.add(number + " in column " + j) ||
                            !seenElement.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
