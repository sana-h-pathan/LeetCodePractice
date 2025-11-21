class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int matches=0;
        int[] s1Freq=new int[26];
        int[] s2Freq=new int[26];
        for(int i=0;i<s1.length();i++){
            char s1Char=s1.charAt(i);
            char s2Char=s2.charAt(i);
            s1Freq[s1Char-'a']++;
            s2Freq[s2Char-'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1Freq[i]==s2Freq[i])
                matches++;
        }
        int l=0;
        int r=s1.length();
        while(r<s2.length()){
            if(matches==26)
                return true;
            int rChar=s2.charAt(r)-'a';
            s2Freq[rChar]++;
            if(s2Freq[rChar]==s1Freq[rChar])
                matches++;
            else if(s2Freq[rChar]-1==s1Freq[rChar])
                matches--;
            int lChar=s2.charAt(l)-'a';
            s2Freq[lChar]--;
            if(s2Freq[lChar]==s1Freq[lChar])
                matches++;
            else if(s2Freq[lChar]+1==s1Freq[lChar])
                matches--;
            l++;
            r++;
        }
        return matches==26;
    }
}