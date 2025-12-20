class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null || logs.size()==0)
            return null;
        Stack<Integer> stk = new Stack<>();
        int curr = 0;
        int prev =0;
        int[] result = new int[n];
        for(String log: logs){
            String[] parts = log.split(":");
            curr = Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){   
                if(!stk.isEmpty()){
                    int idx = stk.peek();
                    result[idx]+= curr-prev;
                    prev = curr;
                }
                stk.push(Integer.parseInt(parts[0]));
            } else {
                int idx = stk.pop();
                result[idx]+= curr+1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}