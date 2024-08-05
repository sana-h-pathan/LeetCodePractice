class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
                if(count>1){
                sb.append(s.charAt(i));
                }
            }
            else{
                if(count>1){
                    sb.append(s.charAt(i));
                }
                count--;
            }
        }
        return sb.toString();
    }
}