class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int r=0;
        int maxLength=0;
        while(r<nums.length){
            while(l <= r && (long)nums[r] > (long)nums[l]*k){ // changed line: cast to long
                l++;
            }
            maxLength = Math.max(r-l+1, maxLength);
            r++;
        }
        return nums.length-maxLength;
    }
}