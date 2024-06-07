class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children=new TrieNode[26];
            this.isEnd=false;
        }
    }
    TrieNode root;

    private void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a']=new TrieNode();
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;

    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        StringBuilder sb=new StringBuilder();
        String[] words=sentence.split(" ");
        for(String word: words){
            TrieNode curr=root;
            StringBuilder replacementWord=new StringBuilder();
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.isEnd ||curr.children[ch - 'a']==null)
                    break;
                curr=curr.children[ch-'a'];
                replacementWord.append(ch);
            }
            if(!curr.isEnd)
                sb.append(word);
            else
                sb.append(replacementWord.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}