public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (k <= 1) 
            return n;
        if (n == 0 || k > n) 
            return 0;

        int maxUnique = 0;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (!seen[ch]) {
                seen[ch] = true;
                maxUnique++;
            }
        }

        int result = 0;

        for (int i=1;i<=maxUnique;i++){
            int[] freq = new int[26];
            int l = 0, r = 0;
            int unique = 0;
            int atLeastK = 0;

            while (r<n) {
                int rchar = s.charAt(r) - 'a';
                if (freq[rchar] == 0) unique++;
                freq[rchar]++;
                if (freq[rchar] == k) atLeastK++;
                r++;

                while (unique>i) {
                    int lchar = s.charAt(l) - 'a';
                    if (freq[lchar] == k) 
                        atLeastK--;
                    freq[lchar]--;
                    if (freq[lchar] == 0) 
                        unique--;
                    l++;
                }

                if (unique == i && atLeastK == i) {
                    result = Math.max(result, r - l);
                }
            }
        }
        return result;
    }
}
