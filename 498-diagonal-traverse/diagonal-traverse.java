class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int idx=0;
        boolean dir=true;
        int i=0;
        int j=0;
        while(idx<result.length){
            result[idx++]=mat[i][j];
            if(dir){
                if(j==n-1){
                    dir=false;
                    i++;
                } else if(i==0){
                    dir = false;
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if(i==m-1){
                    j++;
                    dir=true;
                } else if(j==0){
                    i++;
                    dir=true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}