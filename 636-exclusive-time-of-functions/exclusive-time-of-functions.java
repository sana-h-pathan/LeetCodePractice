class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];
        int currTime=0;
        int prev=0;
        for(String log: logs){
            String[] parts = log.split(":");
            int task = Integer.parseInt(parts[0]);
            currTime = Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){
                if(!stk.isEmpty()){
                    result[stk.peek()]+=currTime-prev;
                    prev = currTime;
                }
                stk.push(task);
            } else {
                result[stk.pop()]+=currTime-prev+1;
                prev = currTime+1;
            }
        }
        return result;
    }

    public int[] exclusiveTime1(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        for(String log : logs){
            String[] parts = log.split(":");
            curr = Integer.parseInt(parts[2]);
            int idx = Integer.parseInt(parts[0]);
            if(parts[1].equals("start")){
                if(!stk.isEmpty()){
                    result[stk.peek()]+=curr-prev;
                    prev = curr;
                }
                stk.push(idx);
            } else {
                result[stk.pop()]+=curr+1-prev;
                prev= curr+1;
            }
        }
        return result;
    }
}