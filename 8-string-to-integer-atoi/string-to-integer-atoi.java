class Solution {
    public int myAtoi(String s) {
        int idx=0;
        int sign = 1;
        int limit = Integer.MAX_VALUE/10;
        int finalNumber = 0;
        int n = s.length();

        while(idx<n && s.charAt(idx) ==' '){
            idx++;
        }
        if(idx<n && s.charAt(idx)=='+'){
            sign = 1;
            idx++;
        } else if(idx<n && s.charAt(idx)=='-'){
            sign = -1;
            idx++;
        }
        while(idx<n && Character.isDigit(s.charAt(idx))){
            int number = s.charAt(idx)-'0';
            if(finalNumber>limit || (finalNumber==limit && number>7)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            finalNumber = finalNumber*10+number;
            idx++;
        }
        return finalNumber*sign;
    }
}