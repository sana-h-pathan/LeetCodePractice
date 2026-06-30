class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int compliment = runningSum-k;
            if(map.containsKey(compliment)){
                result+=map.get(compliment);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }
        return result;
    }
}