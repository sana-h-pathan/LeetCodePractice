class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        // Set to store forbidden words
        Set<String> invalid = new HashSet<>();
        // Adding forbidden words to the set
        for (String currWord: forbidden) {
            invalid.add(currWord);
        }

        // Initializing the answer
        int ans = 0;
        // Initializing the pointer for the right boundary of the current valid substring
        int currRight = word.length() - 1;

        // Looping through the string from right to left
        for (int left = word.length() - 1; left >= 0; left--) {
            // Looping from left to right with a maximum window size of 10 characters
            for (int right = left; right <= Math.min(left + 10, currRight); right++) {
                // Extracting the current substring
                String curr = word.substring(left, right + 1);
                // Checking if the substring is invalid
                if (invalid.contains(curr)) {
                    // If it's invalid, updating the right boundary
                    currRight = right - 1;
                }
            }
            // Updating the answer with the maximum valid substring length found so far
            ans = Math.max(ans, currRight - left + 1);
        }
        // Returning the final answer
        return ans;
    }
}
