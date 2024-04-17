class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int mid=0;
        int r=nums.length-1;
        while(mid<=r){
            if(nums[mid]==2){
                swap(nums,mid,r);
                r--;
            }
            else if(nums[mid]==0){
                swap(nums,l,mid);
                l++;
                mid++;
            }
            else
                mid++;
        }
    }
    private void swap(int[] nums, int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}