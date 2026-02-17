class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for(char ch: s.toCharArray()){
            alphabets[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            alphabets[ch-'a']--;
        }
        for(int i=0;i<alphabets.length;i++){
            if(alphabets[i]!=0){
                return false;
            }
        }
        return true;
    }
}