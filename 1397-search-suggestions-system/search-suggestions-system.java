class Solution {
    class TrieNode {
        TrieNode[] children;
        List<String> suggestedString;
        public TrieNode(){
            this.children = new TrieNode[26];
            suggestedString = new ArrayList<>();
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
            if(curr.suggestedString.size()<3){
                curr.suggestedString.add(word);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String word) {
        this.root = new TrieNode();
        Arrays.sort(products);
        for(String p: products){
            insert(p);
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        boolean dead = false;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!dead && curr.children[ch-'a']!=null){
                curr = curr.children[ch-'a'];
                result.add(curr.suggestedString);
            } else {
                dead = true;
                result.add(Collections.emptyList());
            }
        }
        return result;
    }
}