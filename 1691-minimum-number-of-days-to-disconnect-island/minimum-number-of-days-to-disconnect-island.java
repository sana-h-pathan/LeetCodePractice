class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int initialIslandCount = countIslands(grid);
        if (initialIslandCount != 1) {
            return 0;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);
                if (newIslandCount != 1) return 1;
                grid[row][col] = 1;
            }
        }
        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void exploreIsland(int[][] grid,int row,int col,boolean[][] visited) {
        visited[row][col] = true;

        // Check all adjacent cells
        for (int[] direction : dirs) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check bounds, land, and not visited
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1 &&
            !visited[row][col]
        );
    }
}