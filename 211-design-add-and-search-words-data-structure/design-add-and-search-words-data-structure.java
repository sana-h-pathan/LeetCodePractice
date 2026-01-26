class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word, root, 0);
    }

    private boolean helper(String word, TrieNode curr, int idx){
        if(idx == word.length()){
            return curr.isEnd;
        }

        char ch = word.charAt(idx);

        if(ch == '.'){
            for(int i=0;i<26;i++){
                TrieNode child = curr.children[i];
                if(child != null && helper(word, child, idx + 1)){
                    return true;
                }
            }
            return false;
        }

        if(ch == '*'){
            // Option 1: '*' matches zero characters
            if (helper(word, curr, idx + 1)) {
                return true;
            }

            // Option 2: '*' matches one or more characters
            // consume one char AND move forward in pattern
            for(int i=0;i<26;i++){
                TrieNode child = curr.children[i];
                if(child != null && helper(word, child, idx + 1)){
                    return true;
                }
            }
            return false;
        }

        TrieNode child = curr.children[ch - 'a'];
        if(child == null){
            return false;
        }
        return helper(word, child, idx + 1);
    }
}
