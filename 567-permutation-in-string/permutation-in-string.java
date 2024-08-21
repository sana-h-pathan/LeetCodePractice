class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] s1Freq=new int[26];
        int[] s2Freq=new int[26];
        for(int i=0;i<s1.length();i++){
            int char1=s1.charAt(i)-'a';
            int char2=s2.charAt(i)-'a';
            s1Freq[char1]++;
            s2Freq[char2]++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(s1Freq[i]==s2Freq[i])
                matches++;
        }
        
        int l=0;
        int r=s1.length();
        while(r<s2.length()){
            if(matches==26)
                return true;
            int rVal=s2.charAt(r)-'a';
            s2Freq[rVal]++;
            if(s2Freq[rVal]==s1Freq[rVal])
                matches++;
            else if(s2Freq[rVal]==s1Freq[rVal]+1)
                matches--;
             int lVal=s2.charAt(l)-'a';
            s2Freq[lVal]--;
            if(s2Freq[lVal]==s1Freq[lVal])
                matches++;
             else if(s2Freq[lVal]==s1Freq[lVal]-1)
                matches--;
            l++;
            r++;
        }
        return matches==26;
    }
}