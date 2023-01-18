package practice.medium;

public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }
    public void DFS(char[][] grid, int row, int column){
        if(row<0 || row>=grid.length || column<0 || column>=grid[0].length)
            return;
        if(grid[row][column]=='1'){
            grid[row][column]='2';
            DFS(grid,row+1,column);
            DFS(grid,row-1,column);
            DFS(grid,row,column+1);
            DFS(grid,row,column-1);
        }
    }

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland=new NumberOfIsland();
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},
                {'1','1','0','0','0'},{'0','0','0','1','0'}};
        System.out.println(numberOfIsland.numIslands(grid));
    }
}
