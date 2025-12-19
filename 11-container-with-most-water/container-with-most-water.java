class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxArea=0;
        while(l<=r){
            maxArea = Math.max((r-l)*Math.min(height[l], height[r]), maxArea);
            if(height[l]<height[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}