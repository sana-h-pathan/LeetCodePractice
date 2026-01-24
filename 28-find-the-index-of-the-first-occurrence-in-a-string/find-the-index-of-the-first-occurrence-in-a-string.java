class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m){
            return -1;
        }
        long k=26L;
        long pwr = 1L;
        long nHash=0;
        long hHash=0;
        for(int i=0;i<n;i++){
            pwr = pwr*k;
        }
        for(int i=0;i<n;i++){
            int ch = needle.charAt(i) - 'a'+1;
            nHash=nHash*k+ch;
        }
        int l=0;
        int r=0;
        while(r<haystack.length()){
            int in = haystack.charAt(r) - 'a'+1;
            hHash = hHash*k+in;
            if(r>=n){
                int out = haystack.charAt(l)-'a'+1;
                hHash = hHash - (pwr*out);
                l++;
            }
            if(nHash==hHash){
                return l;
            }
            r++;
        }
        return -1;
    }
}