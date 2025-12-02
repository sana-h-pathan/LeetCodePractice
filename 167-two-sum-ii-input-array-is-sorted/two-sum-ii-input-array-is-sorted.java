class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int sum = nums[l]+nums[r];
            if(sum == target){
                result[0] = l+1;
                result[1] = r+1;
                return result;
            } else if(sum > target){
                r--;
            } else{
                l++;
            }
        }
        return result;
    }
}