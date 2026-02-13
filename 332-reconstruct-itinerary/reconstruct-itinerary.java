class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> t: tickets){
            String from = t.get(0);
            String to = t.get(1);
            if(!map.containsKey(from)){
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(to);
        }
        List<String> result = new ArrayList<>();
        Deque<String> dq = new ArrayDeque<>();
        dq.add("JFK");
        while(!dq.isEmpty()){
            String dest = dq.peek();
            if(map.containsKey(dest) && !map.get(dest).isEmpty()){
                dq.push(map.get(dest).poll());
            } else {
                result.add(dq.poll());
            }
        }
        Collections.reverse(result);
        return result;
    }
}