class Solution {
    public int subarraySum(int[] nums, int k) {
        int runningSum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int diff = runningSum-k;
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }
        return count;
    }
}