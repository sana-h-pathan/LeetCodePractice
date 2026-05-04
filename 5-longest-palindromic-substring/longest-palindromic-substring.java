class Solution {
    int s=0;
    int e=0;
    public String longestPalindrome(String str) {
        if(str==null || str.length()==0){
            return "";
        }
        for(int i=0;i<str.length();i++){
            expandFromMiddle(str, i, i);
            if(i!=str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                expandFromMiddle(str, i, i+1);
            }
        }
        return str.substring(s, e+1);
    }
    private void expandFromMiddle(String str, int l, int r){
        while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        if(e-s<r-l){
            s=l;
            e=r;
        }
    }
}