class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        Queue<int[]> bfsQueue = new LinkedList<>();
        int minutes=0;
        int freshOranges=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                } else if(grid[i][j]==2){
                    bfsQueue.add(new int[]{i,j});
                }
            }
        }
        if(freshOranges==0){
            return minutes;
        }
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            minutes++;
            for(int i=0;i<size;i++){
                int[] curr = bfsQueue.poll();
                for(int[] dir:dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        freshOranges--;
                        if(freshOranges==0){
                            return minutes;
                        }
                        bfsQueue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        if(freshOranges==0){
            return minutes;
        }
        return -1;
    }
}