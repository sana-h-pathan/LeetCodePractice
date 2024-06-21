class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int  n = s.length();
        while (index < n && s.charAt(index) == ' ') { 
            index++; 
        }
        if (index < n && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else
         if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        int limit=Integer.MAX_VALUE/10;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (result > limit || (result == limit && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;           
        }
        return sign * result;
    }
}