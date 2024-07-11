class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                StringBuilder sb=new StringBuilder();
                while(stk.peek()!='(')
                    sb.append(stk.pop());
                stk.pop();
                int idx = 0;
                while (idx < sb.length()){
                    stk.push(sb.charAt(idx++));
                }
            }else{
                stk.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.empty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}