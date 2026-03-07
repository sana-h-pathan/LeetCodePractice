class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> bfsQue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    bfsQue.add(new int[]{i,j});
                }
            }
        }
        while(!bfsQue.isEmpty()){
            int[] curr = bfsQue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<m;i++){
                matrix[i][c] = 0;
            }
            for(int j=0;j<n;j++){
                matrix[r][j] = 0;
            }
        }
    }
}