package practice.medium;

public class NumberOfIsland {
    public static void DFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            DFS(grid, i + 1, j);
            DFS(grid, i - 1, j);
            DFS(grid, i, j + 1);
            DFS(grid, i, j - 1);
        }
    }
        public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                    DFS(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland=new NumberOfIsland();
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},
                {'1','1','0','0','0'},{'0','0','0','1','0'}};
        numberOfIsland.numIslands(grid);
    }
}
