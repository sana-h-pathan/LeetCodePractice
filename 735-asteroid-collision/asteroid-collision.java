class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int a: asteroids){
            while(!stk.isEmpty() && stk.peek()>0 && a<0){
                if(Math.abs(stk.peek())<Math.abs(a)){
                    stk.pop();
                    continue;
                } else if(Math.abs(stk.peek())==Math.abs(a)){
                    stk.pop();
                }
                a=0;
                break;
            }
            if(a!=0){
                stk.push(a);
            }
        }
        int[] result = new int[stk.size()];
        for(int i=stk.size()-1;i>=0;i--){
            result[i] = stk.pop();
        }
        return result;
    }
}