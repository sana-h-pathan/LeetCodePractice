class Solution {
    int start=0;
    int end =0;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int n=s.length();
        for(int i=0;i<s.length();i++){
            expandFromMiddle(s, i, i);
            if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                expandFromMiddle(s, i, i+1);
            }
        }
        return s.substring(start, end+1);
    }
    private void expandFromMiddle(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        if(end-start<r-l){
            start=l;
            end=r;
        }
    }
}