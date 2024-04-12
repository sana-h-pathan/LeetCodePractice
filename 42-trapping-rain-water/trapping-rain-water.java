class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftWall=0;
        int rightWall=0;
        int area=0;
        while(left<=right){
            if(leftWall<rightWall){
                if(leftWall>height[left])
                    area+=(leftWall-height[left])*1;
                else
                    leftWall=height[left];
                left++;
            }
            else{
                if(rightWall>height[right])
                    area+=(rightWall-height[right])*1;
                else
                    rightWall=height[right];
                right--;
            }
        }
        return area;
    }
}