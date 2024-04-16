class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int runningProduct=1;
        result[0]=1;
        for(int i=1;i<n;i++){
            runningProduct*=nums[i-1];
            result[i]=runningProduct;
        }
        runningProduct=1;
        for(int i=n-2;i>=0;i--){
            runningProduct*=nums[i+1];
            result[i]*=runningProduct;
        }

        return result;
    }
}