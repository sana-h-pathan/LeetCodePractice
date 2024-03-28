class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String word: wordList)
            set.add(word);

        if(!set.contains(endWord))
            return 0;
        Queue<String> bfsQueue=new LinkedList<>();
        bfsQueue.add(beginWord);
        int step=0;
        while(!bfsQueue.isEmpty()){
            int size=bfsQueue.size();
            step++;
            for(int k=0;k<size;k++){  
                String curr=bfsQueue.poll();
                for(int i=0;i<curr.length();i++){
                    char[] chars = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String currWord=new String(chars);
                        if(set.contains(currWord)){
                            if(currWord.equals(endWord))
                                return step+1;
                            bfsQueue.add(currWord);
                            set.remove(currWord);
                        }

                    }
                }
            }
        }
        return 0;
    }
}