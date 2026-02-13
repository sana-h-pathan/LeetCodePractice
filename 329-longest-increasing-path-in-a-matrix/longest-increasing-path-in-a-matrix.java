public class Solution {
    int[][] dirs;
    int m;
    int n;
    int[][] dp; // changed: memo table

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) // changed
            return 0;

        this.m = matrix.length;
        this.n = matrix[0].length;
        this.dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        this.dp = new int[m][n]; // changed

        int result = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                result = Math.max(result, helper(matrix, i, j));
            }
        }
        return result;
    }

    private int helper(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) 
            return dp[i][j]; // changed: reuse memo

        int best = 1; // changed: length including this cell
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[i][j]) {
                best = Math.max(best, 1 + helper(matrix, nr, nc)); // changed
            }
        }
        dp[i][j] = best; // changed: store
        return best;
    }
    private int helper1(int[][] matrix, int i, int j) {
        int result = 0;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n   // changed (nc < n)
                && matrix[nr][nc] > matrix[i][j]) {      // same
                result = Math.max(result, helper(matrix, nr, nc));
            }
        }
        return result + 1; // changed (clearer than ++result)
    }
}
