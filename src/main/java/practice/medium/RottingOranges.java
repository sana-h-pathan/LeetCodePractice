package practice.medium;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int res = 0;

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return res;

        int R = grid.length;
        int C = grid[0].length;
        int[][] next = null;
        while(true){
            next = new int[R][C];
            int fresh = 0;
            int rotten = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(grid[i][j] == 1){
                        fresh++;
                        if((i+1 < R && grid[i+1][j] == 2) ||
                                (j+1 < C && grid[i][j+1] == 2) ||
                                (i > 0 && grid[i-1][j] == 2) ||
                                (j > 0 && grid[i][j-1] == 2)){
                            rotten++;
                            next[i][j] =2;
                        }
                        else
                            next[i][j] = grid[i][j];
                    }
                    else
                        next[i][j] = grid[i][j];
                }
            }

            if(fresh == 0)
                return res;
            if(rotten == 0)
                return -1;
            res++;

            grid = next;
        }
    }

    public static void main(String[] args) {
        RottingOranges rottingOranges=new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }
}
