class Solution {
    List<String> wordDict;
    List<String> res = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        dp(s, 0, new LinkedList<>());
        return res;
    }
    
    void dp(String s, int startIndex, LinkedList<String> path) {
        if(startIndex == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        
        for(String word: wordDict) {
            int endIndex = startIndex+word.length();
            if(endIndex<=s.length() && s.substring(startIndex,endIndex).equals(word)) {
                path.add(word);
                dp(s, endIndex, path);
                path.removeLast();
            }
        }
    }
}
