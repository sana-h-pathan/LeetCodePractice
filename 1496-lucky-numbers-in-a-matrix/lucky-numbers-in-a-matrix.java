class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0;i< matrix.length;i++) {
            int m=Integer.MAX_VALUE,mi=0;
            for (int j=0;j<matrix[i].length;j++) {
                if (matrix[i][j]<m) {
                    m=matrix[i][j];
                    mi=j;
                }
            }
            int flag=0;
            for (int k=0;k< matrix.length;k++) {
                if (matrix[k][mi]>matrix[i][mi]) {
                    flag=1;
                    break;
                }
            }
            if (flag==0) {
                ans.add(matrix[i][mi]);
            }
        }
        return ans;
    }
}