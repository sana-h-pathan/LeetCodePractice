import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        if (k == 1) {
            return nums;
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // indices, nums decreasing

        int l = 0;
        int r = 0;

        while (r < n) {
            // maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) {
                dq.pollLast();
            }
            dq.addLast(r);

            // if window size == k, record answer and slide
            if (r - l + 1 == k) {
                result[l] = nums[dq.peekFirst()];

                // remove outgoing index if it's at front
                if (!dq.isEmpty() && dq.peekFirst() == l) {
                    dq.pollFirst();
                }
                l++;
            }
            r++;
        }
        return result;
    }
}
