class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)){
                continue;
            } else if(ch=='('){
                stk.push(i);
            } else {
                if(!stk.isEmpty() && s.charAt(stk.peek())=='('){
                    stk.pop();
                } else {
                    stk.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stk);
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}