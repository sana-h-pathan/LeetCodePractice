class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
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