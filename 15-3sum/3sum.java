class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if (nums ==null || nums.length < 3)
            return result;
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            
            if(nums[i]>0)
                break;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            while(l<r){
                int sum=nums[l]+nums[r]+nums[i];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1])
                        l++;
                    while(l<r && nums[r]==nums[r+1])
                        r--;
                }
                else if(sum>0)
                    r--;
                else
                    l++;
            }
            
        }
        return result;
    }
}