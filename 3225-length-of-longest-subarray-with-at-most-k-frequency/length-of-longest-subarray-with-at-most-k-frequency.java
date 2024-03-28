class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            while (count.get(nums[j]) > k)
                count.put(nums[i], count.get(nums[i++]) - 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}