public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int i = 1; i <= maxUnique; i++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int l = 0;
            int r = 0;
            int idx = 0;
            int unique = 0, countAtLeastK = 0;
            while (r < str.length) {
                // expand the sliding window
                if (unique <= i) {
                    idx = str[r] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    r++;
                }
                // shrink the sliding window
                else {
                    idx = str[l] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    l++;
                }
                if (unique == i && unique == countAtLeastK)
                    result = Math.max(r - l, result);
            }
        }
        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}
