class Solution {
    public int calculate(String s) {
        int n=s.length();
        char lastSign ='+';
        int currNum=0;
        int sum=0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum=currNum*10+ch-'0';
            }
            if((!Character.isDigit(ch) && ch!=' ')||i==n-1){
                if(lastSign=='+'){
                    stk.push(+currNum);
                } else if(lastSign=='-'){
                    stk.push(-currNum);
                } else if(lastSign=='*'){
                    stk.push(stk.pop()*currNum);
                } else if(lastSign=='/'){
                    stk.push(stk.pop()/currNum);
                }
                currNum = 0;
                lastSign = ch;
            }
        }
        while(!stk.isEmpty()){
            sum+=stk.pop();
        }
        return sum;
    }
}