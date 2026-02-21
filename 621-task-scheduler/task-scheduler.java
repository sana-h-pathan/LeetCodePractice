class Solution {
    public int leastInterval(char[] tasks, int n) {
        //A=4, B=4, C=3 n=2
        //AB_AB_AB_AB
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq=0;
        for(char t: tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(t));
        }
        int maxCount=0;
        for(char ch: map.keySet()){
            if(map.get(ch)==maxFreq){
                maxCount++;
            }
        }
        int totalTask=tasks.length;
        int partition = maxFreq-1;
        int availableSlot = partition * (n-(maxCount-1));
        int pendingTask = totalTask - (maxFreq*maxCount);
        int idleSlot = Math.max(0, availableSlot-pendingTask);

        return totalTask+idleSlot;
    }
}