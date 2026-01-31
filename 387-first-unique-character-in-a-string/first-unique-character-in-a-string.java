class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] charArr = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            charArr[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(charArr[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}