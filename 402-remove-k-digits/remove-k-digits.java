class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k==n){
            return "0";
        }
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = num.charAt(i);
            while(!stk.isEmpty() && k>0 && stk.peek()>ch){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(k>0){
            stk.pop();
            k--;
        }
        for(char ch: stk){
            sb.append(ch);
        }
        int idx=0;
        while(idx<sb.length()-1 && sb.charAt(idx)=='0'){
            idx++;
        }
        return sb.substring(idx, sb.length()).toString();
    }
}