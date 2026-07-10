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
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(curr, 0, word);
    }
    private boolean helper(TrieNode curr, int idx, String word){
        if(idx==word.length()){
            return curr.isEnd;
        }
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                TrieNode child = curr.children[i];
                if(child!=null && helper(child, idx+1, word)){
                    return true;
                }
            }
            return false;
        }
        if(curr.children[ch-'a']!=null){
            curr = curr.children[ch-'a'];
            return helper(curr, idx+1, word);
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