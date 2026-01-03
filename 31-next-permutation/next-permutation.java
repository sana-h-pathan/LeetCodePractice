class Solution {
    public void nextPermutation(int[] nums) {
        //14586431
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //i=2  at 5 and 8
        int j = n-1;
        if(i>=0){
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i, j);
            //j=4 at 6
            //14685431
        }
        reverse(nums, i+1, n-1);
        //14613458
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[]nums, int l, int r){
        while(l<=r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r]=temp;
            l++;
            r--;
        }

    }
}