import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // handle edge case
        if (nums == null || nums.length == 0 || k < 0) return "";

        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();
        for(String num: nums) {
            minHeap.offer(new BigInteger(num));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.isEmpty() ? "" : String.valueOf(minHeap.peek());
    }
}
// time is o(nlogk), space is o(k)