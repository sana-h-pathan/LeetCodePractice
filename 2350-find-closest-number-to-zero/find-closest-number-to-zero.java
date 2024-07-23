class Solution {
    public int findClosestNumber(int[] nums) {
        int min=Math.abs(nums[0]);
        int result=nums[0];
        for(int num: nums){
            int currDiff=Math.abs(num);
            if(currDiff<min){
                result=num;
                min=currDiff;
            }
            if(min == currDiff && num > result){
                result = num;
            }
        }
        return result;
    }
}