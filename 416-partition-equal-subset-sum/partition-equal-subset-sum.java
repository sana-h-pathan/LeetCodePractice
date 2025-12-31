class Solution {
    // This problem can be solved using a dynamic programming approach, similar to the coin change problem.
    public boolean canPartition(int[] nums) {
        int totalSum = 0; // Variable to store the total sum of the numbers in the array
        for (int n : nums)
            totalSum += n; // Calculate the total sum of the numbers in the array

        // If the total sum is odd, it's not possible to partition the array into two equal halves
        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2; // Calculate the target sum for each partition

        int m = nums.length; // Number of elements in the array
        boolean[][] dp = new boolean[m + 1][target + 1]; // Dynamic programming table to store results
        dp[0][0] = true; // Base case: If target sum is 0, it's always achievable with an empty subset

        // Initialize the first column of the dp table to true, as a sum of 0 is always achievable
        for (int k = 1; k <= m; k++) {
            dp[k][0] = true;
        }

        // Iterate through each element and possible target sum to fill up the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j]; // If the current number is greater than the target sum, exclude it
                else{
                    // Include the current number and check if the remaining sum can be achieved
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // The last cell of the dp table indicates if it's possible to achieve the target sum with given numbers
        return dp[m][target];
    }
}
