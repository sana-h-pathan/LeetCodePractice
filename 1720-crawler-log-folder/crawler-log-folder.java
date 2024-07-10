class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk=new Stack<>();
        for(String log: logs){
            if(log.startsWith("./"))
                continue;
            else if(log.startsWith("../")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else{
                stk.push(log);
            }
        }
        return stk.size();
    }
}