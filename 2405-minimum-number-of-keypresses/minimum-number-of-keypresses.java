class Solution {
    public int minimumKeypresses(String s) {
        int n=s.length();
        if(n<=9)
            return s.length();
        Integer[] freqCount=new Integer[26];
        Arrays.fill(freqCount, 0);
        int totalPress=0;
        for(int i=0;i<n;i++){
            freqCount[s.charAt(i)-'a']++;
        }
        Arrays.sort(freqCount,(a,b)->b-a);
        for(int i=0;i<26;i++){
            if(i<9)
                totalPress+=freqCount[i];
            else if(i<18)
                totalPress+=2*freqCount[i];
            else
                totalPress+=3*freqCount[i];
        }
        return totalPress;
    }
}