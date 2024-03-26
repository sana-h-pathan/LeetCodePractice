class Solution {
    public int minOperations(int[] nums) {
        var counter = new HashMap<Integer, Integer>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int c: counter.values()) {
            if (c == 1) {
                return -1;
            }
            count += c / 3; // Count the complete sets of 3 elements
            if (c % 3 != 0) // If there are remaining elements, increment the count
                count++;
        }
        return count;
    }
}