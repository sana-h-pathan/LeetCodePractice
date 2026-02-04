class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String t: tokens){
            if(t.equals("+")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(a+b);
            } else if(t.equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b-a);
            } else if(t.equals("*")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b*a);
            } else if(t.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b/a);
            } else {
                stk.push(Integer.parseInt(t));
            }
        }
        return stk.peek();
    }
}