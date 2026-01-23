class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10+ch-'0';
            }
            else if(ch=='['){
                numStk.push(currNum);
                strStk.push(currStr);
                currNum=0;
                currStr = new StringBuilder();
            } else if(ch==']'){
                int currIteration = numStk.pop();
                StringBuilder ns = new StringBuilder();
                for(int k=0;k<currIteration;k++){
                    ns.append(currStr);
                }
                StringBuilder parentStr = strStk.pop();
                currStr = parentStr.append(ns);
            } else {
                currStr.append(ch);
            }
        }
         return currStr.toString(); 
    }
}