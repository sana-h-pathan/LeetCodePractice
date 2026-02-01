class Solution {
    class TrieNode{
        TrieNode[] children;
        List<String> wordList;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.wordList = new ArrayList<>();
        }
    }
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
            if(curr.wordList.size()<3){
                curr.wordList.add(word);
            }
        }
    }
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.root = new TrieNode();
        Arrays.sort(products);
        for(String p: products){
            insert(p);
        }
        TrieNode curr = root;
        List<List<String>> result = new ArrayList<>();
        boolean dead = false;
        for(int i=0;i<searchWord.length();i++){
            char ch = searchWord.charAt(i);
            if(!dead && curr.children[ch-'a']!=null){
                curr = curr.children[ch-'a'];
                result.add(curr.wordList);
            } else {
                dead = true;
                result.add(Collections.emptyList());
            }
        }
        return result;
    }
}