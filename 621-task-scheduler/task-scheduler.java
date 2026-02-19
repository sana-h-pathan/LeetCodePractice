class Solution {
    public int leastInterval(char[] tasks, int n) {
        //A=4, B=4, C=3 n=2
        //AB_AB_AB_AB
        int maxFreq=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char t: tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(t));
        }
        int maxCount =0;
        for(char ch: map.keySet()){
            if(map.get(ch)==maxFreq){
                maxCount++;
            }
        }
        int totalTask = tasks.length;
        int partition = maxFreq-1;
        int availableSlot = partition * (n-(maxCount-1));
        int pendingSlot = totalTask - (maxFreq*maxCount);
        int idleSlot = Math.max(0, availableSlot-pendingSlot);

        return idleSlot+totalTask;
    }
}