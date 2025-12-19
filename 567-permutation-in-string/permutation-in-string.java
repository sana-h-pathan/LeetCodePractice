class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for(int i=0;i<s1.length();i++){
            int s1Char = s1.charAt(i) - 'a';
            int s2Char = s2.charAt(i) - 'a';
            s1Freq[s1Char]++;
            s2Freq[s2Char]++;
        }
        int matches = 0;
        for(int i=0;i<26;i++){
            if(s1Freq[i]==s2Freq[i]){
                matches++;
            }
        }
        int l=0;
        int r=s1.length();
        while(r<s2.length()){
            if(matches==26)
                return true;
            int rInt = s2.charAt(r)-'a';
            s2Freq[rInt]++;
            if(s1Freq[rInt] == s2Freq[rInt]){
                matches++;
            } 
            else if(s1Freq[rInt]==s2Freq[rInt]-1){
                matches--;
            }
            int lInt = s2.charAt(l) - 'a';
            s2Freq[lInt]--;
            if(s1Freq[lInt]==s2Freq[lInt]){
                matches++;
            } else if(s1Freq[lInt]==s2Freq[lInt]+1){
                matches--;
            }
            l++;
            r++;
        }
        return matches==26;
    }
}