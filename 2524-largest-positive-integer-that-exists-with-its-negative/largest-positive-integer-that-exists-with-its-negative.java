class Solution {
    public int findMaxK(int[] nums) {
        int n=nums.length;
        if(n==1) 
        return -1;
        Arrays.sort(nums);
        int i=0,j=n-1; 
        while(i<j){
            if(nums[i]+nums[j]==0)
                return nums[j];
            else if(nums[i]+nums[j]>0)
                j--;
            else
                i++;
       }
       return -1;
    }
}