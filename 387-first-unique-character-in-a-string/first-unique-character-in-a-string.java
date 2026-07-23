class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] alphabets = new int[26];
        for(char ch:s.toCharArray()){
            alphabets[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(alphabets[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}