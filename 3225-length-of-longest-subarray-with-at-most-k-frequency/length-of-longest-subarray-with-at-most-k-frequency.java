class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int length = 0;
        int left = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            numCount.put(nums[right], numCount.getOrDefault(nums[right], 0) + 1);
            while (numCount.get(nums[right]) > k)
                numCount.put(nums[left], numCount.get(nums[left++]) - 1);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}