class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        long needleHash=0l;
        long hayHash=0l;
        long k=26l;
        long kn = 1L;
        
        for (int i = 0; i < n; i++) {
            kn *= k;
        }
        for(int i=0;i<n;i++){
            char c=needle.charAt(i);
            needleHash=needleHash*k + (c-'a' + 1);
        }
        for(int i=0;i<m;i++){
            char in=haystack.charAt(i);
            hayHash=hayHash*k + (in-'a' + 1);
            if(i>=n){
                char out=haystack.charAt(i-n);
                hayHash=hayHash - ((out-'a' + 1) * kn);
            }
            if(hayHash==needleHash)
                return i-n+1;
        }
        return -1;
    }
}
