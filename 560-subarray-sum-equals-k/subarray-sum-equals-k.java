class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int runningSum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int diff=runningSum-k;
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            map.put(runningSum, map.getOrDefault(runningSum,0)+1);
        }
        return count;
    }
}