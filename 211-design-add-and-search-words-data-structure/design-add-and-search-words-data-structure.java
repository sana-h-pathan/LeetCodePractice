public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean flag;
        public TrieNode() {
            children = new TrieNode[26];
            flag = false;
        }
    }
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.flag = true;
    }
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(word,0,curr);
    }
    private boolean helper(String word, int start, TrieNode curr) {
        if (start == word.length()) {
            return curr.flag;
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (helper(word,start+1,curr.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            if (curr.children[c-'a'] == null) 
                return false;
            return helper(word,start+1,curr.children[c-'a']);
        }
        return false;
    }
    
}