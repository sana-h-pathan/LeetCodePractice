class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;//3
        int n=matrix[0].length; //4
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int col=mid%n;
            int row=mid/n;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
    }
}