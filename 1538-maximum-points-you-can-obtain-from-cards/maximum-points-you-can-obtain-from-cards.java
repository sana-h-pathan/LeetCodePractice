class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum=0;
        int rSum=0;
        int maxSum=0;
        int r=cardPoints.length-1;
        int l=k-1;
        for(int i=0;i<k;i++)
            lSum+=cardPoints[i];
        maxSum=Integer.max(maxSum,lSum);
        while(l>=0){
            lSum=lSum-cardPoints[l];
            rSum+=cardPoints[r];
            r--;
            l--;
            maxSum=Integer.max(maxSum,lSum+rSum);
        }
        return maxSum;
    }
}