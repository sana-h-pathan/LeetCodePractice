class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        int l=0;
        int r=0;
        int i=0;
        int n = chars.length;
        while(r<n){
            char ch = chars[r];
            while(r<n && chars[l]==chars[r]){
                r++;
            }
            chars[i++] = ch;
            int count = r-l;
            if(count>1){
                String cntStr = String.valueOf(count);
                for(char c: cntStr.toCharArray()){
                    chars[i++]=c;
                }
            }
            l=r;
        }
        return i;
    }
}