class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m){
            return -1;
        }
        long nHash=0L;
        long hHash=0L;
        long k = 26L;
        long pwr = 1L;
        for(int i=0;i<n;i++){
            pwr*=k;
        }
        for(int i=0;i<n;i++){
            int ch = (needle.charAt(i)-'a')+1;
            nHash = nHash*k+ch;
        }
        int l=0;
        int r=0;
        while(r<m){
            int in = (haystack.charAt(r)-'a')+1;
            hHash = hHash*k+in;
            if(r>=n){
                int out = (haystack.charAt(l)-'a')+1;
                hHash = hHash - (out*pwr);
                
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