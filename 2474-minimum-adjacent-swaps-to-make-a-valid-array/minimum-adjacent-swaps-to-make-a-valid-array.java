class Solution {
    public int minimumSwaps(int[] nums) {
        // Variables to store minimum and maximum values, their indices, and length of the array
        int minNum = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;
        int n = nums.length;
        
        // Iterate through the array to find the minimum and maximum values and their indices
        for(int i = 0; i < n; i++) {
            // Update minimum value and its index if a smaller value is found
            if(nums[i] < minNum) {
                minNum = nums[i];
                minIdx = i;
            }
            // Update maximum value and its index if a larger value is found
            if(nums[i] >= maxNumber) {
                maxNumber = nums[i];
                maxIdx = i;
            }
        }
        
        // Check if the minimum index is greater than the maximum index
        if(minIdx > maxIdx)
            // Return the number of swaps required to bring the maximum element to its correct position 
            // and the minimum element to its correct position
            return (n - maxIdx - 1) + minIdx - 1;
        
        // Return the number of swaps required to bring the maximum element to its correct position 
        // and the minimum element to its correct position
        return (n - maxIdx - 1) + minIdx;
    }
}
