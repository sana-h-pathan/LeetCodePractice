class Solution {

    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Track minimum cost to reach each cell
        int[][] minCost = new int[m][n];
        for (int[] i : minCost) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        // Use deque for 0-1 BFS - add zero cost moves to front, cost=1 to back
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});
        minCost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];

            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dirs[dir][0];
                int nc = c + dirs[dir][1];
                int cost = (grid[r][c] != (dir + 1)) ? 1 : 0;

                // If position is valid and we found a better path
                if (isValid(nr,nc,m,n) && minCost[r][c]+cost<minCost[nr][nc]) {
                    minCost[nr][nc] = minCost[r][c]+cost;

                    // Add to back if cost=1, front if cost=0
                    if (cost==1){
                        deque.offerLast(new int[]{nr,nc});
                    } else {
                        deque.offerFirst(new int[]{nr,nc});
                    }
                }
            }
        }

        return minCost[m-1][n-1];
    }

    // Check if coordinates are within grid bounds
    private boolean isValid(int r,int c,int nr,int nc) {
        return r>=0 && r<nr && c>=0 && c<nc;
    }
}