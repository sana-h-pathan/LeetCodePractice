class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String tok:tokens){
            if(tok.equals("+")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(a+b);
            } else if(tok.equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b-a);
            } else if(tok.equals("*")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(a*b);
            } else if(tok.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b/a);
            } else {
                stk.add(Integer.parseInt(tok));
            }
        }
        return stk.peek();
    }
}