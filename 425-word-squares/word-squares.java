class Solution {

    class TrieNode{
        TrieNode[] children;
        ArrayList<String> startsWith;
        public TrieNode(){
            this.children=new TrieNode[26];
            this.startsWith=new ArrayList<>();
        }
    }

    private void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a']=new TrieNode();
            curr= curr.children[ch-'a'];
            curr.startsWith.add(word);
        }
    }
    private List<String> search(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null)
                return new ArrayList<>();
            curr=curr.children[ch-'a'];
        }
        return curr.startsWith;
    }

    TrieNode root;
    public List<List<String>> wordSquares(String[] words) {
        this.root=new TrieNode();
        for(String word: words)
            insert(word);
        List<List<String>> result=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        for(String word: words){
            temp.add(word);
            backtrack(temp,result);
            temp.remove(temp.size()-1);
        }
        return result;
    }
    private void backtrack(List<String> temp, List<List<String>> result){
        if(temp.get(0).length()==temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder prefix=new StringBuilder();
        int idx=temp.size();
        for(String word: temp){
            prefix.append(word.charAt(idx));
        }
        List<String> startsWith=search(prefix.toString());
        for(String word: startsWith){
            temp.add(word);
            backtrack(temp, result);
            temp.remove(temp.size()-1);
        }
    }
}