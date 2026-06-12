

import javax.crypto.Cipher;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int freshOranges = 0;
        Queue<int[]> bfsQue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    bfsQue.add(new int[]{i,j});
                } else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int mins=0;
        if(freshOranges==0){
            return mins;
        }
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            mins++;
            for(int i=0;i<size;i++){
                int[] curr = bfsQue.poll();
                for(int[] dir: dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        bfsQue.add(new int[]{nr, nc});
                        grid[nr][nc]=2;
                        freshOranges--;
                        if(freshOranges==0){
                            return mins;
                        }
                    }
                }
            }
        }
        if(freshOranges==0){
            return mins;
        }
        return -1;
    }
}