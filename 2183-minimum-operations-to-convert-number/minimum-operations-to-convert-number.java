class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int result = 0;
        Queue<Integer> bfsQue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        bfsQue.offer(start);
        
        while(!bfsQue.isEmpty()){
            int size = bfsQue.size();
            for(int i = 0;i<size;i++){
                int curr = bfsQue.poll();
                if(curr == goal)
                    return result;
                if((curr < 0 || curr > 1000) || set.contains(curr))
                    continue;
                if(!set.contains(curr))
                    set.add(curr);

                for(int num : nums){
                    bfsQue.offer(curr + num);
                    bfsQue.offer(curr - num);
                    bfsQue.offer(curr ^ num);
                }
            }
            result++;
        }
        return -1;
    }
}