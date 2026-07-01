class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(words==null || words.length ==0){
            return new ArrayList<>();
        }
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA==freqB){
                return b.compareTo(a);
            }
            return Integer.compare(freqA, freqB);
        });
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for(String key: map.keySet()){
            pq.add(key);

            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}