class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new LinkedList<>();
        Deque<Integer> minDq = new LinkedList<>();
        int idx = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; ++i) {
            while (!maxDq.isEmpty() && maxDq.peekLast() < nums[i]) {
                maxDq.pollLast();
            }
            maxDq.offerLast(nums[i]);

            while (!minDq.isEmpty() && minDq.peekLast() > nums[i]) {
                minDq.pollLast();
            }
            minDq.offerLast(nums[i]);

            while (maxDq.peekFirst() - minDq.peekFirst() > limit) {
                if (maxDq.peekFirst() == nums[idx]) {
                    maxDq.pollFirst();
                }
                if (minDq.peekFirst() == nums[idx]) {
                    minDq.pollFirst();
                }
                ++idx;
            }

            maxLength = Math.max(maxLength, i - idx + 1);
        }

        return maxLength;
    }
}