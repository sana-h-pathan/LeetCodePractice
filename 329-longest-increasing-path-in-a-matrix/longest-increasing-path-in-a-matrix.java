public class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] indegree = new int[m][n];
        Queue<int[]> bfsQue = new ArrayDeque<>();
        // build indegree
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        // add all indegree 0 nodes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0)
                    bfsQue.add(new int[]{i, j});   // changed to add
            }
        }
        int result = 0;
        while (!bfsQue.isEmpty()) {
            int size = bfsQue.size();
            result++;
            for (int i = 0; i < size; i++) {
                int[] curr = bfsQue.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[curr[0]][curr[1]]) {
                        indegree[nr][nc]--;
                        if (indegree[nr][nc] == 0)
                            bfsQue.add(new int[]{nr, nc});  // changed to add
                    }
                }
            }
        }

        return result;
    }

    public int longestIncreasingPath1(int[][] matrix) {
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
