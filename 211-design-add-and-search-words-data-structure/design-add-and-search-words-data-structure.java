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
                curr.children[ch-'a']= new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(curr, word, 0);
    }

    private boolean helper(TrieNode curr, String word, int idx) {
        if(idx==word.length()){
            return curr.isEnd;
        }
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                TrieNode child = curr.children[i];
                if(child!=null && helper(child, word, idx+1)){
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = curr.children[ch -'a'];
            if(child==null){
                return false;
            }
            return helper(child, word, idx+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */