class Solution {
    public int numberOfSubstrings(String s) {
        int result=0;
        int a=-1;
        int b=-1;
        int c=-1;
        int l=0;
        int r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            switch (ch) {
                case 'a':
                    a=r;
                    break;
                case 'b':
                    b=r;
                    break;
                case 'c':
                    c=r;
                    break;
                default:
                    break;
            }
            r++;
            if(a!=-1 && b!=-1 && c!=-1){
                l = Math.min(a, Math.min(b, c));
                result+=l+1;
            }
        }

        return result;
    }
}