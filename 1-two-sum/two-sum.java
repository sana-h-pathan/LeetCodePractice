class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{-1,-1};
        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                result[0] = i;
                result[1] = map.get(compliment);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}