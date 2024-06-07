class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findSub(nums, k)-findSub(nums, k-1);
    }
    private int findSub(int[] nums,int k){
        if(k<0)
            return 0;
        int l=0;
        int r=0;
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size()>k){
                map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
                if(map.get(nums[l])==0)
                    map.remove(nums[l]);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}