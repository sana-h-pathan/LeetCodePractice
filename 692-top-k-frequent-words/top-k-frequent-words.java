class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         if(words == null && words.length == 0) {
            return new ArrayList<>();
        }
        Map<String,Integer> map = new HashMap<>();
        
        for(String w : words){
            
            map.put(w, map.getOrDefault(w,0)+1);
        }
        
        Queue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare(map.get(a), map.get(b)); // ascending by frequency
            if (freqCompare == 0) {
                return b.compareTo(a); // if freq same → higher lexicographically first
            }
            return freqCompare;
        });

        
        
        for(String key: map.keySet()){
            pq.offer(key);
            //create heap in a way that we can remove string whose count is less or we can remove string which is lexicographicallly high
            //so we sort it in ascending order as we will be removing from start
            //also we sort with lex desc order so that higher lex will be removed first with poll
            if(pq.size() > k){
                pq.poll();
            }
            
        }
        
        List<String> res= new LinkedList<>();
        
        
        while(!pq.isEmpty()){
            res.add(0,pq.poll());
        }
        
        return res;
        
    }
}