import java.util.Collections;

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        int first=helper(0,n-1,nums);
        int second=helper(1,n,nums);
        return Math.max(first,second);
    }

    public int helper(int start, int end, int[] nums){
        int prev=nums[start];
        int curr=Math.max(nums[start],nums[start+1]);     
        for(int i=start+2;i<end;i++){
            int temp=curr;
            curr=Math.max(curr,prev+nums[i]);
            prev=temp;
        }
        return curr;
    }
}