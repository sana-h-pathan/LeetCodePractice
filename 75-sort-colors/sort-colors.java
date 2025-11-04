class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
            else if(nums[mid]==0){
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else{
                mid++;
            }
        }
    }
    private void swap(int[] nums, int l, int h){
        int temp=nums[l];
        nums[l]=nums[h];
        nums[h]=temp;
    }
}