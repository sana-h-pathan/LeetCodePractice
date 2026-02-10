class Solution {
    //DQ-2026-02-10
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        int l = 0;
        while (l < n) {
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            int r = l;
            while (r < n) {
                if (nums[r]%2==0) 
                    even.add(nums[r]);
                else
                    odd.add(nums[r]);

                if (even.size() == odd.size()) {
                    maxLength = Math.max(maxLength, r - l + 1);
                }
                r++;
            }
            l++;
        }
        return maxLength;
    }
}
