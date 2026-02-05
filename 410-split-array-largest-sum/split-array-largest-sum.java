class Solution {
    public int splitArray(int[] nums, int k) {
        if (nums.length < k) return -1;

        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int parts = calculate(nums, mid);

            if (parts > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;   // answer
    }

    private int calculate(int[] nums, int capacity) {
        int count = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num <= capacity) {
                currSum += num;
            } else {
                count++;
                currSum = num;
            }
        }
        return count;
    }
}
