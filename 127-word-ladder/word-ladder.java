class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>();
        for(String word: wordList)
            wordSet.add(word);
        if(!wordSet.contains(endWord))
            return 0;
        int steps=0;
        Queue<String> bfsQue=new LinkedList<>();
        bfsQue.add(beginWord);
        while(!bfsQue.isEmpty()){
            steps++;
            int size=bfsQue.size();
            for(int i=0;i<size;i++){
                String curr=bfsQue.poll();
                for(int j=0;j<curr.length();j++){
                    char[] currChar=curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        currChar[j]=ch;
                        String currWord=new String(currChar);
                        if(wordSet.contains(currWord)){
                            if(currWord.equals(endWord))
                                return steps+1;
                            bfsQue.add(currWord);
                            wordSet.remove(currWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}