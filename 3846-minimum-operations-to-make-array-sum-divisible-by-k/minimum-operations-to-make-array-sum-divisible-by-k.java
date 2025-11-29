class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        int max=0;
        for(int num:nums){
            sum+=num;
            max=Integer.max(max, num);
        }
        int remainder=sum%k;
        return remainder;
    }
}