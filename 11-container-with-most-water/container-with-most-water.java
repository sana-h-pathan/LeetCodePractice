class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int maxArea=0;
        int l=0;
        int r=height.length-1;
        while(l<=r){
            int currArea = (r-l)*Math.min(height[l], height[r]);
            maxArea = Math.max(currArea, maxArea);
            if(height[l]>height[r]){
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}