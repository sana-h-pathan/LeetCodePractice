class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            result.add(new ArrayList<>(Arrays.asList(lower,upper)));
            return result;
        }
        if(nums[0]>lower){
            int start=lower;
            int end=nums[0]-1;
            result.add(new ArrayList<>(Arrays.asList(start,end)));
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1])
                continue;
            else{
                int start=nums[i]+1;
                int end=nums[i+1]-1;
                result.add(new ArrayList<>(Arrays.asList(start,end)));
            }
        }
        if(nums[n-1]<upper){
            int start=nums[n-1]+1;
            int end=upper;
            result.add(new ArrayList<>(Arrays.asList(start,end)));
        }
        return result;
    }
}

