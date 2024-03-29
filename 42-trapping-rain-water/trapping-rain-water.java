class Solution {
//TC=O(n)
//SC=O(1)
    public int trap1(int[] height) {
        int n=height.length;
        int max=0;
        int maxHeightIdx=-1;
        int maxArea=0;
        
        for(int i=0;i<n;i++){
            if(height[i]>max){
                max=height[i];
                maxHeightIdx=i;
            }
        }
        int leftWall=0;
        for(int j=0;j<maxHeightIdx;j++){
            if(height[j]<leftWall){
                maxArea+=leftWall-height[j];
            }
            else{
                leftWall=height[j];
            }
        }
        int rightWall=0;
        for(int j=n-1;j>maxHeightIdx;j--){
            if(height[j]<rightWall){
                maxArea+=rightWall-height[j];
            }
            else{
                rightWall=height[j];
            }    
        }
       return maxArea; 
    }
    public int trap(int[] height) {
        int right=height.length-1;
        int leftWall=0;
        int rightWall=0;
        int left=0;
        int maxArea=0;
        while(left<=right){
            if(leftWall<=rightWall){
                if(height[left]<leftWall){
                    maxArea+=(leftWall-height[left])*1;
                }
                else{
                    leftWall=height[left];
                } 
                left++;
            }
            else{
                if(height[right]<rightWall){
                    maxArea+=(rightWall-height[right])*1;
                }
                else{
                    rightWall=height[right];
                } 
                right--;
            }
        }
        return maxArea;
    }
}