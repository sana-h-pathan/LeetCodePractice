class Solution {
    List<String> wordDict;
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        backtracking(s, 0, new ArrayList<>());
        return result;
    }
    
    void backtracking(String s, int startIndex, ArrayList<String> path) {
        if(startIndex == s.length()) {
            result.add(String.join(" ", path));
            return;
        }
        
        for(String word: wordDict) {
            int endIndex = startIndex+word.length();
            if(endIndex<=s.length() && s.substring(startIndex,endIndex).equals(word)) {
                path.add(word);
                backtracking(s, endIndex, path);
                path.removeLast();
            }
        }
    }
}
