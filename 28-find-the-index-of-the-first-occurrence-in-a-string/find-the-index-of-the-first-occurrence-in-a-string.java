class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m){
            return -1;
        }
        long k = 26L;
        long nHash = 0L;
        long hHash = 0L;
        long pwr = 1L;
        for(int i=0;i<n;i++){
            pwr*=k;
        }
        for(int i = 0;i<n;i++){
            int ch = (needle.charAt(i)-'a')+1; //as a starts from 0 to avoid it add 1
            nHash = nHash*k+ch;
        }
        for(int i=0;i<m;i++){
            int in = (haystack.charAt(i)-'a')+1;
            hHash = hHash*k+in;
            if(i>=n){
                int out = (haystack.charAt(i-n)-'a')+1;
                hHash = hHash - (out*pwr);
            }
            if(hHash == nHash){
                return i-n+1;
            }
        }
        return -1;
    }
}