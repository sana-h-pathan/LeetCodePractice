class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c: word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int result=0;
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>((a,b)->b-a);
        frequencyQueue.addAll(map.values());
        int idx = 0;
        while (!frequencyQueue.isEmpty()) {
            result += (idx / 8 + 1) * frequencyQueue.poll();
            idx++;
        }
        return result;
        
    }
}