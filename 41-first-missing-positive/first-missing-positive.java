class Solution {
    public int firstMissingPositive(int[] nums) {
      int len = nums.length;
        Set<Integer> current = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            current.add(nums[i]);
        }
        int i = 1;
        for(; i < Integer.MAX_VALUE; i++){
            if(!current.contains(i))
                return i;
        }
        return i; 
    }
}