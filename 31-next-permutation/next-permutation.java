class Solution {
    public void nextPermutation(int[] nums) {
        //14685431
        //finding breach i.e where previous number is less than the current number
        //find index of number thats greater than breached value
        //swap them
        //reverse entire number
        if(nums==null || nums.length==0){
            return;
        }
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        int j = n-1;
        if(i>=0){
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    private void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}