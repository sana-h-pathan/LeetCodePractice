class Solution {
    public int compress(char[] chars) {
        if(chars==null || chars.length==0){
            return 0;
        }
        int l=0;
        int r=0;
        int idx=0;
        while(r<chars.length){
            while(r<chars.length && chars[r]==chars[l]){
                r++;
            }
            chars[idx] = chars[l];
            idx++;
            if(r-l>1){
                String len = String.valueOf(r-l);
                for(char ch: len.toCharArray()){
                    chars[idx] = ch;
                    idx++;
                }
            }
            l = r;
        }
        return idx;
    }
}