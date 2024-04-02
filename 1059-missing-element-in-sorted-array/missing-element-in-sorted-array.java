// binary search
// time = o(logn)
// space = o(1)

class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        
        // If kth missing number is larger than 
        // the last element of the array then return 
        int missingNum = nums[high] - nums[low] - high;
        if(k > missingNum)
            return nums[high] + k - missingNum;
        
        while(low <= high) {
            int pivot = low + (high - low) / 2;
            missingNum = nums[pivot] - nums[0] - pivot;
            
            if (missingNum >= k)
                high = pivot - 1;
            else
                low = pivot + 1;
        }
        
        return nums[0] + k + high;
    }
}