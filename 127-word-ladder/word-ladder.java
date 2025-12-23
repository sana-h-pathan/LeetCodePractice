class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> bfsQue = new LinkedList<>();
        bfsQue.add(beginWord);
        int count =0;
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            count++;
            for(int i=0;i<size;i++){
                String curr = bfsQue.poll();
                for(int j=0;j<curr.length();j++){
                    char[] currChar = curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        currChar[j]=ch;
                        String newCurr = new String(currChar);
                        if(set.contains(newCurr)){
                            if(newCurr.equals(endWord)){
                                return count+1;
                            }
                            bfsQue.add(newCurr);
                            set.remove(newCurr);
                        }
                    }
                }
            }
        }
        return 0;
    }
}