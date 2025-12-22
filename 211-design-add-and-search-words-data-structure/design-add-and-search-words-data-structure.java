class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
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
            if(curr.children[ch - 'a']==null){
                curr.children[ch -'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(word, curr, 0);
    }
    private boolean helper(String word, TrieNode curr, int idx){
        if(word.length()==idx){
            return curr.isEnd;
        }
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null){
                    if(helper(word, curr.children[i], idx+1))
                        return true;
                }
            }

        } else {
            if(curr.children[ch - 'a']==null){
                return false;
            }
            return helper(word, curr.children[ch-'a'], idx+1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */