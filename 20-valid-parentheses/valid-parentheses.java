class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stk.push(')');
            } else if(ch=='['){
                stk.push(']');
            } else if(ch=='{'){
                stk.push('}');
            } else {
                if(stk.isEmpty()|| stk.peek()!=ch){
                    return false;
                }
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}