class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);
        int count=0;
        while(!bfsQueue.isEmpty()){
            int size= bfsQueue.size();
            count++;
            for(int i=0;i<size;i++){
                String currWord = bfsQueue.poll();
                for(int j=0;j<currWord.length();j++){
                    char[] currChar = currWord.toCharArray();
                    for(char ch ='a';ch<='z';ch++){
                        currChar[j]=ch;
                        String newString = new String(currChar);
                        if(set.contains(newString)){
                            set.remove(newString);
                            bfsQueue.add(newString);
                            if(newString.equals(endWord)){
                                return count+1;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}