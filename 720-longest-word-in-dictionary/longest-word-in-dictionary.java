class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> bfsQue = new LinkedList<>();
        Queue<String> wQue = new LinkedList<>();
        wQue.add("");
        String maxStr="";
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TrieNode curr = bfsQue.poll();
            maxStr = wQue.poll();
            for(int i=25;i>=0;i--){
                TrieNode child = curr.children[i];
                if(child!=null && child.isEnd){
                    bfsQue.add(child);
                    wQue.add(maxStr + (char)('a' + i));
                }
            }
        }
        return maxStr;
    }
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }
}