class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        int diff = dfs(nums, 0, n - 1, memo);
        return diff >= 0;
    }

    // returns max score difference current player can achieve over opponent
    private int dfs(int[] nums, int l, int r, Integer[][] memo) {
        if (l == r) return nums[l];
        if (memo[l][r] != null) return memo[l][r];

        int takeLeft = nums[l] - dfs(nums, l + 1, r, memo);
        int takeRight = nums[r] - dfs(nums, l, r - 1, memo);

        memo[l][r] = Math.max(takeLeft, takeRight);
        return memo[l][r];
    }
}
