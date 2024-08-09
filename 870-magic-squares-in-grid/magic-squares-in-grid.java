class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i+2<m;i++){
            for(int j=0;j+2<n;j++){
                if(isMagical(grid,i,j))
                    count++;
            }
        }
        return count;
    }
    private boolean isMagical(int[][] grid, int r, int c){
        HashSet<Integer> set=new HashSet<>();
        for(int i=r;i<=r+2;i++){
            for(int j=c;j<=c+2;j++){
                int num=grid[i][j];
                if((num<1 || num>9)||set.contains(num))
                    return false;
                set.add(num);
            }
        }
        int diag1=grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2];
        int diag2=grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c];
        if(diag1!=diag2)
            return false;

        int row1=grid[r][c]+grid[r][c+1]+grid[r][c+2]; //00 01 02
        int row2=grid[r+1][c]+grid[r+1][c+1]+grid[r+1][c+2]; //10 11 12
        int row3=grid[r+2][c]+grid[r+2][c+1]+grid[r+2][c+2]; //20 21 22

        if (!(row1 == diag1 && row2 == diag1 && row3 == diag1)) {
            return false;
        }

        int col1=grid[r][c]+grid[r+1][c]+grid[r+2][c]; //00 10 20
        int col2=grid[r][c+1]+grid[r+1][c+1]+grid[r+2][c+1]; // 01 11 21 
        int col3=grid[r][c+2]+grid[r+1][c+2]+grid[r+2][c+2]; // 02 12 22

        if (!(col1 == diag1 && col2 == diag1 && col3 == diag1)) {
            return false;
        }
        return true;
    }
}