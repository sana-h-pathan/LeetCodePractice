class Solution {

    public void solveSudoku(char[][] board) {
        helper(board);
    }
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') 
                    continue;

                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(board, i, j, ch)) {
                        board[i][j] = ch;
                        if (helper(board)) 
                            return true;
                        board[i][j] = '.'; // backtrack
                    }
                }
                return false; // no number fits here
            }
        }
        return true; // solved (no empty cells)
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {

        // row + col
        for (int k = 0; k < 9; k++) {
            if (board[r][k] == ch) 
                return false;
            if (board[k][c] == ch) 
                return false;
        }

        // 3x3 box
        int br = (r / 3) * 3;
        int bc = (c / 3) * 3;

        for (int i = br; i < br + 3; i++) {
            for (int j = bc; j < bc + 3; j++) {
                if (board[i][j] == ch) 
                    return false;
            }
        }

        return true;
    }
}
