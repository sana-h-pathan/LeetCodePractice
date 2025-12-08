class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean dir=true;
        int totalElements=m*n;
        int[] result= new int[totalElements];
        int i=0;
        int j=0;
        int idx=0;
        while(idx<totalElements){
            result[idx++]=mat[i][j];
            if(dir){
                if(i==0 && j<n-1){
                    j++;
                    dir=false;
                } else if(j==n-1){
                    i++;
                    dir=false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if(j==0 && i<m-1){
                    i++;
                   dir=true;
                } else if(i==m-1){
                    j++;
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