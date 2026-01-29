class Solution {
    public int compress(char[] chars) {
        if(chars==null || chars.length==0){
            return 0;
        }
        int l=0;
        int r=0;
        int i=0;
        while(r<chars.length){
            char ch = chars[l];
            while(r<chars.length && chars[l]==chars[r]){
                r++;
            }
            chars[i++]=ch;
            if(r-l>1){
                String cntStr = String.valueOf(r-l);
                for(char c: cntStr.toCharArray()){
                    chars[i++]=c;
                }
            }
            l=r;
        }
        return i;
    }
}