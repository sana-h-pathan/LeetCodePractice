class AutocompleteSystem {
    class TrieNode{
        List<String> wordList;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[256];
            this.wordList= new ArrayList<>();
        }
    }
    HashMap<String, Integer> dictionary;
    StringBuilder searchString;
    TrieNode root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.searchString = new StringBuilder();
        this.dictionary = new HashMap<>();
        this.root = new TrieNode();
        for(int i=0;i<times.length;i++){
            String sentence = sentences[i];
            int time = times[i];
            if(!dictionary.containsKey(sentence)){
                insertTrie(sentence);
            }
            dictionary.put(sentence, dictionary.getOrDefault(sentence, 0)+time);
        }
    }

    private void insertTrie(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-' ']==null)
                curr.children[ch-' '] = new TrieNode();
            curr = curr.children[ch - ' '];
            curr.wordList.add(word);
        }
    }

    private List<String> searchTrie(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - ' ']==null)
               return new ArrayList<>();
            curr = curr.children[ch - ' '];
        }
        return curr.wordList;
    }
    
    public List<String> input(char c) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(dictionary.get(a)==dictionary.get(b))
                return b.compareTo(a);
            return dictionary.get(a)-dictionary.get(b);
        });
        if(c == '#'){
            String searchSentence = searchString.toString();
            this.searchString = new StringBuilder();
            if(!dictionary.containsKey(searchSentence)){
                insertTrie(searchSentence);
            }
            dictionary.put(searchSentence, dictionary.getOrDefault(searchSentence, 0)+1);
            return new ArrayList<>();
        }
        searchString.append(c);
        String searchSentence = searchString.toString();
        List<String> sentences = searchTrie(searchSentence);
        for(String sentence: sentences){
                pq.add(sentence);
                if(pq.size()>3)
                    pq.poll();
        }
        List<String> result=new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(0,pq.poll());
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */