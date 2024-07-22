class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0;
        int r=0;
        int maxSum=0;
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        while(r<nums.length){
            int num=nums[r];
            while(set.contains(num)){
                set.remove(nums[l]);
                sum-=nums[l];
                l++; 
            }
            set.add(num);
            sum+=num;
            maxSum=Integer.max(maxSum, sum);
            r++;
        }
        return maxSum;
    }
}