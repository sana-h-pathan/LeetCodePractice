class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] origMatrix = new int[m][n];
        int i = 0, j = 0;

        while (i < m && j < n) {
            origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= origMatrix[i][j];
            colSum[j] -= origMatrix[i][j];

            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }

        return origMatrix;
    }
}