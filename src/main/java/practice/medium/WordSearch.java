package practice.medium;

import java.util.HashSet;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        HashSet wordSet=new HashSet();
        for (char c : word.toCharArray()) {
            wordSet.add(c);
        }
        for(int i=0;i<board.length;i++) {
            HashSet alphabetSet=new HashSet();
            for (int j=0;j<board[0].length;j++){
                alphabetSet.add(board[i][j]);
            }
            if(alphabetSet.equals(wordSet))
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        WordSearch wordSearch=new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }
}
