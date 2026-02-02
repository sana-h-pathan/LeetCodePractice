class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) 
            return result;

        int l = 0;

        while (l < nums.length) {
            int r = l;
            while (r + 1 < nums.length && nums[r] + 1 == nums[r + 1]) {
                r++;
            }

            if (l == r) {
                result.add(String.valueOf(nums[l]));
            } else {
                result.add(nums[l] + "->" + nums[r]);
            }

            l = r + 1; // move left pointer to next new range
        }

        return result;
    }
}
