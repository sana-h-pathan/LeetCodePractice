class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        int maxCount = 0; // Tracks the count of the most frequent character in the current window

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, map.get(c));

            // If the number of characters to replace exceeds k, shrink the window
            while (r - l + 1 - maxCount > k) {
                char ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                l++;
            }

            // Update the maximum length of the window
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
    
}