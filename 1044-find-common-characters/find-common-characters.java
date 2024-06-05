class Solution {
    public List<String> commonChars(String[] words) {
        int[] word=new int[26];
        for(char c : words[0].toCharArray())
            word[c-'a']++;
        for(int i=1;i<words.length;i++){
            word=findCommon(word, words[i]);
        }
        List<String> result=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if(word[i]!=0){
                int k=word[i];
                while(k!=0){
                    result.add(String.valueOf((char) ('a' + i)));
                    k--;
                }
            }
        }
        return result;
    }
    private int[] findCommon(int[] word1, String s2){
        int[] word2=new int[26];
        for(char c : s2.toCharArray())
            word2[c-'a']++;
        int[] result=new int[26];
        for(int i=0;i<26;i++){
            result[i]=Math.min(word1[i],word2[i]);
        }
        return result;
    }
}