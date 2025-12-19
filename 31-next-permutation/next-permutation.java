class Solution {
    public void nextPermutation(int[] nums) {
        //14586431
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        int j=n-1;
        if(i>=0){
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums, int l, int r){
        while(l<=r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}