class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length(), l = 0, res = 0;
        Trie tries = new Trie();
        for (String s : forbidden) 
            tries.insert(s);
        for (int i = 0; i < n; i++) {
            while (tries.isValid(word, l, i)) 
                l++;
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    class Trie {
        Trie[] next;
        int cnt;
        boolean end;

        Trie() {
            this.next = new Trie[26];
            this.cnt = 0;
            this.end = false;
        }

        void insert(String s) {
            Trie cur = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new Trie();
                cur = cur.next[idx];
                cur.cnt++;
            }
            cur.end = true;
        }

        boolean isValid(String s, int l, int r) {
            Trie cur = this;
            for (int i = r; i >= l; i--) {
                int idx = s.charAt(i) - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
                if (cur.end) return true;
            }
            return false;
        }
    }
}