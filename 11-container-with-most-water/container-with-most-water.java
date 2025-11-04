class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while(l<=r){
            int currArea = (r-l)*Math.min(height[l],height[r]);
            maxArea = Math.max(currArea, maxArea);
            if(height[l]>height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return maxArea;
    }
}