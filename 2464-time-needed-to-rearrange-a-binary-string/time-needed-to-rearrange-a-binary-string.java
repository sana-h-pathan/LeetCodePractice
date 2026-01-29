class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0;
        int time = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            } else {
                if (zeros > 0) {
                    time = Math.max(time + 1, zeros);
                }
            }
        }
        return time;
    }
}
