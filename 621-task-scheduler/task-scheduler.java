class Solution {
    public int leastInterval(char[] tasks, int n) {
        int l=tasks.length;
        HashMap<Character, Integer> map=new HashMap<>();
        int maxFreq=0;
        int maxCount=0;
        for(char task: tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
            maxFreq=Integer.max(maxFreq, map.get(task));
        }
        for(char task: map.keySet()){
            if(map.get(task)==maxFreq)
                maxCount++;
        }
        int partition=maxFreq-1;
        int available=partition*(n-(maxCount-1));
        int pending=l-maxCount*maxFreq;
        int idle=Math.max(0, available-pending);

        return l+idle;
    }
}