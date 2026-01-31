class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(mid<=r){
            if(nums[mid]==0){
                swap(nums, mid,l);
                l++;
                mid++;
            } else if(nums[mid]==2){
                swap(nums, mid, r);
                r--;
            } else {
                mid++;
            }
        }
    }
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}