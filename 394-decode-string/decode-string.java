class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum=0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = currNum*10+ch-'0';
            } else if(ch=='['){
                numStk.push(currNum);
                strStk.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            } else if(ch==']'){
                int currItr = numStk.pop();
                StringBuilder newStr = new StringBuilder();
                for(int i=0;i<currItr;i++){
                    newStr.append(currStr);
                }
                currStr = strStk.pop();
                currStr.append(newStr);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}