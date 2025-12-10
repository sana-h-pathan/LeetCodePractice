class Solution {
    class TrieNode{
        TrieNode[] children;
        List<String> wordList;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.wordList = new ArrayList<>();
        }
    }

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
            curr.wordList.add(word);
        }
    }

    private List<String> search(TrieNode root, String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                return new ArrayList<>();
            curr = curr.children[ch-'a'];
        }
        return curr.wordList;
    }

    public List<List<String>> wordSquares(String[] words) {
        TrieNode root= new TrieNode();
        for(String word: words)
            insert(root,word);
        List<List<String>> result=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        for(String word: words){
            temp.add(word);
            backTrack(root, result, temp);
            temp.remove(temp.size()-1);
        }
        return result;
    }

    private void backTrack(TrieNode root, List<List<String>> result, List<String> temp){
        if(temp.get(0).length()==temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        int idx = temp.size();
        for(String word: temp){
            prefix.append(word.charAt(idx));
        }
        List<String> wordList = search(root, prefix.toString());
        for(String word: wordList){
            temp.add(word);
            backTrack(root, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}