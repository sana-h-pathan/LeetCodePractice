class Solution {
    public long subsequenceSumOr(int[] nums) {
        // Array to store the count of bits set at each position (0 to 63)
        // Using long to accommodate large numbers
        long[] bitSetCounts = new long[64];
        long result = 0;

        // Loop through each number in the array
        for (int num : nums) {
            // Loop through each bit position (0 to 30)
            // since the input numbers are in the range of int
            for (int i = 0; i < 31; ++i) {
                // Check if the ith bit of the current number is set
                if ((num & (1 << i)) != 0) {
                    // If yes, increment the count of set bits at that position
                    ++bitSetCounts[i];
                }
            }
        }

        // Loop through each bit position (0 to 62)
        // since we're calculating the OR of subsequences
        for (int i = 0; i < 63; ++i) {
            // If there are any set bits at the current position
            if (bitSetCounts[i] > 0) {
                // Set the corresponding bit in the result
                result |= 1L << i;
            }
            // Carry over any excess bits to the next position
            bitSetCounts[i + 1] += bitSetCounts[i] / 2;
        }

        return result;
    }
}