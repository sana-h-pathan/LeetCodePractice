class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<4){
            int max=nums[0];
            for(int i=0;i<n;i++){
                max=Math.max(max,nums[i]);
            }
            return max;
        }
        int first=helper(0,n-1,nums);
        int second=helper(1,n,nums);
        return Math.max(first,second);
    }

    public int helper(int start, int end, int[] nums){
        int prev2=nums[start];
        int prev1=Math.max(nums[start],nums[start+1]);     
        for(int i=start+2;i<end;i++){
            int notPick = prev1;
            int pick = nums[i]+prev2;
            int curr = Math.max(pick, notPick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}