class Solution {
    int start=0;
    int end=0;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";

        int n=s.length();
        for(int i=0;i<n;i++){
            expandFromMiddle(i,i,s);
            if(i<n-1 && s.charAt(i)==s.charAt(i+1))
                expandFromMiddle(i,i+1,s);
        }
        return s.substring(start,end+1);
    }

    private void expandFromMiddle(int l, int r, String s){
        while(l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        if(end-start<=r-l){
            start=l;
            end=r;
        }
    }
    
}