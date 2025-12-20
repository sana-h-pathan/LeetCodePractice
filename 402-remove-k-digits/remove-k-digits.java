class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        int n = num.length();
        if(n==k)
            return "0";
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!stk.isEmpty() && stk.peek()>ch && k>0){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(k>0 && !stk.isEmpty()){
            k--;
            stk.pop();
        }
        if(stk.isEmpty())
            return "0";
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.insert(0,stk.pop());
        }
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') 
            i++;
        sb.delete(0, i);
        return sb.toString();
    }
}