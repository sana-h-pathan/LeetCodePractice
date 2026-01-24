class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
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
        }
        curr.isEnd = true;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder replacementSentence = new StringBuilder();
        for(String word: words){
            StringBuilder replacementWord = new StringBuilder();
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null || curr.isEnd){
                    break;
                }
                replacementWord.append(ch);
                curr = curr.children[ch-'a'];
            }
            if(!curr.isEnd){
                replacementSentence.append(word);
            } else {
                replacementSentence.append(replacementWord.toString());
            }
            replacementSentence.append(" ");
        }
        return replacementSentence.toString().trim();
    }
}