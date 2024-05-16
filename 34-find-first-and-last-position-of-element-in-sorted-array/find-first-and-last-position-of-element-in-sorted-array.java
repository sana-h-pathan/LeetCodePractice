class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int[] result=new int[]{-1,-1};
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid!=0 && nums[mid]==nums[mid-1]){
                    high=mid-1;
                }
                else{
                    result[0]=mid;
                    break;
                }
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        if(result[0]==-1)
            return result;
        low=result[0];
        high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid!=nums.length-1 && nums[mid]==nums[mid+1]){
                    low=mid+1;
                }
                else{
                    result[1]=mid;
                    break;
                }
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return result;
    }
}