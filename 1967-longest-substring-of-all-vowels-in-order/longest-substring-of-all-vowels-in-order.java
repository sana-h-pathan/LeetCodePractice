class Solution {
    public int longestBeautifulSubstring(String word) {
        if(word.length()<5){
            return 0;
        }
        int l=0;
        int r=1;
        int vowelCount=1;
        int maxLength=0;
        while(r<word.length()){
            if(word.charAt(r)<word.charAt(r-1)){
                l=r;
                vowelCount=1;
            } else if(word.charAt(r)!=word.charAt(r-1)){
                vowelCount++;
            }
            if(vowelCount==5){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}