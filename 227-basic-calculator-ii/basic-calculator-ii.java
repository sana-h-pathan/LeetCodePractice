class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        char lastSign = '+';
        int curr = 0;
        int result =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10+ch - '0';
            }
            if((!Character.isDigit(ch) && ch!= ' ') || i==n-1){
                if(lastSign=='+'){
                    stk.push(+curr);
                } else if(lastSign=='-'){
                    stk.push(-curr);
                } else if(lastSign=='*'){
                    stk.push(stk.pop() * curr);
                } else if(lastSign=='/'){
                    stk.push(stk.pop()/curr);
                }
                curr=0;
                lastSign=ch;
            }
        }
        while(!stk.isEmpty()){
            result+=stk.pop();
        }
        return result;
    }
}