class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int sign = 1;
        int result = 0;
        int num = 0;
        int i=0;
        int n = s.length();
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            } else if(ch=='+'){
                result += sign*num;
                num=0;
                sign = 1;
            } else if(ch=='-'){
                result += sign*num;
                num=0;
                sign = -1;
            } else if(ch=='('){
                stk.push(result);
                stk.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            } else if(ch==')'){
                result += sign*num;
                num = 0;
                int prevSign = stk.pop();
                int prevResult = stk.pop();
                result = prevResult+prevSign*result;
            }
            i++;
        }
        result += sign*num;
        return result;
    }
}