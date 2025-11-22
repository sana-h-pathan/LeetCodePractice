class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        int steps=0;
        if(!set.contains(endWord))
            return steps; 
        Queue<String> bfsQue=new LinkedList<>();
        bfsQue.add(beginWord);
        while(!bfsQue.isEmpty()){
            int size=bfsQue.size();
            steps++;
            for(int i=0;i<size;i++){
                String curr=bfsQue.poll();
                for(int j=0;j<curr.length();j++){
                    char[] currChar=curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        currChar[j]=ch;
                        String currWord=new String(currChar);
                        if(set.contains(currWord)){
                            if(currWord.equals(endWord))
                                return steps+1;
                            bfsQue.add(currWord);
                            set.remove(currWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}